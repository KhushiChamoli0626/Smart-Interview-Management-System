package com.khushi.smart_interview_management.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.khushi.smart_interview_management.entity.Job;
import com.khushi.smart_interview_management.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    // POST : save job
    @PostMapping
    public Job addJob(@Valid @RequestBody Job job) {
        return service.saveJob(job);
    }

    // GET : fetch all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return service.getAllJobs();
    }

    // GET : fetch job by id
    @GetMapping("/{id}")
    public Job getJobId(@PathVariable Long id) {
        return service.getJobById(id);
    }

    // DELETE : deletes job by id
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return "Job Deleted Successfully";
    }

    @PostMapping("/bulk")
    public List<Job> addJobs(@Valid @RequestBody List<Job> jobs) {
       return service.saveAllJobs(jobs);
    }

    @GetMapping("/search")
    public List<Job> searchJob(@RequestParam String title){
        return service.searchJob(title);
    }
}
