/*package com.khushi.smart_interview_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.entity.Interview;
import com.khushi.smart_interview_management.repository.InterviewRepository;

@Service // This class contains the business logic
public class InterviewService {

    @Autowired
    private InterviewRepository repository;

    // POST/SAVE interview
    public Interview saveInterview(Interview interview) {
        return repository.save(interview);
    }

    // GET all interviews
    public List<Interview> getAllInterviews() {
        return repository.findAll();
    }

    // GET interview by id
    public Interview getInterviewById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE interview by id
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Interview> saveAllInterviews(List<Interview> interviews) {
        return repository.saveAll(interviews);
    }
} */


package com.khushi.smart_interview_management.service;

import java.util.List;

import com.khushi.smart_interview_management.repository.CandidateRepository;
import com.khushi.smart_interview_management.repository.JobRepository;
import com.khushi.smart_interview_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.entity.Interview;
import com.khushi.smart_interview_management.entity.Job;
import com.khushi.smart_interview_management.entity.User;
import com.khushi.smart_interview_management.repository.InterviewRepository;



@Service
public class InterviewService {

    @Autowired
    private InterviewRepository repository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    // Schedule Interview
    /*public Interview saveInterview(Interview interview) {

        // Save interview first
        Interview savedInterview = repository.save(interview);

        // Get details
        Candidate candidate = savedInterview.getCandidate();
        Job job = savedInterview.getJob();
        User interviewer = savedInterview.getInterviewer();

        // Send email
        emailService.sendInterviewEmail(
                candidate.getEmail(),
                candidate.getName(),
                job.getTitle(),
                interviewer.getName(),
                savedInterview.getInterviewDateTime().toString());

        return savedInterview;
    }*/

    public Interview saveInterview(Interview interview) {

       // Save interview
       Interview savedInterview = repository.save(interview);

       // Fetch complete Candidate
       Candidate candidate = candidateRepository
            .findById(savedInterview.getCandidate().getId())
            .orElseThrow(() -> new RuntimeException("Candidate not found"));

       // Fetch complete Job
       Job job = jobRepository
            .findById(savedInterview.getJob().getId())
            .orElseThrow(() -> new RuntimeException("Job not found"));

       // Fetch complete Interviewer
       User interviewer = userRepository
            .findById(savedInterview.getInterviewer().getId())
            .orElseThrow(() -> new RuntimeException("Interviewer not found"));

       // Debug (optional)
       System.out.println(candidate.getEmail());
       System.out.println(candidate.getName());
       System.out.println(job.getTitle());
       System.out.println(interviewer.getName());

       // Send Email
       emailService.sendInterviewEmail(
            candidate.getEmail(),
            candidate.getName(),
            job.getTitle(),
            interviewer.getName(),
            savedInterview.getInterviewDateTime().toString());

       return savedInterview;
    }

    // Get all interviews
    public List<Interview> getAllInterviews() {
        return repository.findAll();
    }

    // Get interview by id
    public Interview getInterviewById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete interview
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Bulk save
    public List<Interview> saveAllInterviews(List<Interview> interviews) {
        return repository.saveAll(interviews);
    }
}
