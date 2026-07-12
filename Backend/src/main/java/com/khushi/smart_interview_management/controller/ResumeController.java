/*package com.khushi.smart_interview_management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

import com.khushi.smart_interview_management.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload/{candidateId}")
    public ResponseEntity<String> uploadResume(
            @PathVariable Long candidateId,
            @RequestParam("file") MultipartFile file)
            throws IOException {

        return ResponseEntity.ok(resumeService.uploadResume(candidateId, file));
    }

    @PostMapping("/upload/bulk")
    public ResponseEntity<String> uploadBulkResumes(
           @RequestParam("files") MultipartFile[] files)
           throws IOException {

        return ResponseEntity.ok("All resumes uploaded successfully");
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadResume(@PathVariable String fileName) throws IOException {
        return resumeService.downloadResume(fileName);
    }
} */


package com.khushi.smart_interview_management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.khushi.smart_interview_management.service.ResumeService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    // ==========================================
    // Upload Single Resume
    // ==========================================
    @PostMapping("/upload/{candidateId}")
    public ResponseEntity<String> uploadResume(
            @PathVariable Long candidateId,
            @RequestParam("file") MultipartFile file)
            throws IOException {

        String message = resumeService.uploadResume(candidateId, file);

        return ResponseEntity.ok(message);
    }


    // ==========================================
    // Download Resume
    // ==========================================
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadResume(
            @PathVariable String fileName)
            throws IOException {

        return resumeService.downloadResume(fileName);
    }

}