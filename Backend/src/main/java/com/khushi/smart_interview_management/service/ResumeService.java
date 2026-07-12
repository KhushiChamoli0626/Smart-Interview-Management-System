/*package com.khushi.smart_interview_management.service;

import java.util.UUID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.repository.CandidateRepository;

@Service
public class ResumeService {

    @Autowired
    private CandidateRepository candidateRepository;

    // uploads folder path
    private final String UPLOAD_DIR = "uploads/";

    public String uploadResume(Long candidateId, MultipartFile file)
            throws IOException {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        // Create uploads folder if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Original filename
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Copy file to uploads folder
        Files.copy(
                file.getInputStream(),
                uploadPath.resolve(fileName),
                StandardCopyOption.REPLACE_EXISTING);

        // Save filename in database
        candidate.setResumeFileName(fileName);

        candidateRepository.save(candidate);

        return "Resume uploaded successfully";
    }

    public ResponseEntity<Resource> downloadResume(String fileName)
        throws IOException {

        Path path = Paths.get("uploads").resolve(fileName);

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            throw new RuntimeException("Resume not found");
        }

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
    }
} */



package com.khushi.smart_interview_management.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.repository.CandidateRepository;

@Service
public class ResumeService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Upload folder
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    // =========================
    // Upload Resume
    // =========================
    public String uploadResume(Long candidateId, MultipartFile file)
            throws IOException {

        // Find Candidate
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        // Check if file is selected
        if (file.isEmpty()) {
            throw new RuntimeException("Please select a file");
        }

        // Get original filename
        String originalFile = file.getOriginalFilename();

        // Allow only PDF, DOC, DOCX
        if (originalFile == null ||
                !(originalFile.toLowerCase().endsWith(".pdf")
                        || originalFile.toLowerCase().endsWith(".doc")
                        || originalFile.toLowerCase().endsWith(".docx"))) {

            throw new RuntimeException(
                    "Only PDF, DOC and DOCX files are allowed.");
        }

        // Create uploads folder if it doesn't exist
        Path uploadPath = Paths.get(UPLOAD_DIR);

        Files.createDirectories(uploadPath);

        // Generate unique filename
        String fileName = UUID.randomUUID() + "_" + originalFile;

        System.out.println("Upload Path : " + uploadPath.toAbsolutePath());
        System.out.println("Saving File : " + fileName);

        // Save file to uploads folder
        Path filePath = uploadPath.resolve(fileName);

       System.out.println(filePath.toAbsolutePath());

       Files.copy(
          file.getInputStream(),
          filePath,
          StandardCopyOption.REPLACE_EXISTING);

        // Save filename in database
        candidate.setResumeFileName(fileName);

        candidateRepository.save(candidate);

        return "Resume uploaded successfully";
    }

    // =========================
    // Download Resume
    // =========================
    public ResponseEntity<Resource> downloadResume(String fileName)
            throws IOException {

        Path path = Paths.get(UPLOAD_DIR).resolve(fileName);

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            throw new RuntimeException("Resume not found");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
