package com.khushi.smart_interview_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.entity.Job;
import com.khushi.smart_interview_management.repository.JobRepository;

@Service // This class contains business logic
public class JobService {

    @Autowired // Create the object automatically and inject it here
    private JobRepository repository;

    // POST/SAVE jobs
    public Job saveJob(Job job) {
        return repository.save(job);
    }

    // GET all jobs
    public List<Job> getAllJobs() { // List of all jobs
        return repository.findAll();
    }

    // GET job by id
    public Job getJobById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE job by id
    public void deleteJob(Long id) {
        repository.deleteById(id);
    }

    //POST/SAVE : save jobs in bulk
    public List<Job> saveAllJobs(List<Job> jobs) {
        return repository.saveAll(jobs);
    }

    //SEARCH/GET
    public List<Job> searchJob(String title){  
       return repository.findByTitleContainingIgnoreCase(title);
    }
}
