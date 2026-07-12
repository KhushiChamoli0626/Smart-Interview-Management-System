package com.khushi.smart_interview_management.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.khushi.smart_interview_management.entity.User;
import com.khushi.smart_interview_management.enums.CandidateStatus;
import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.service.CandidateService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService service;

    // POST : save candidates
    @PostMapping("path")
    public Candidate addCandidate(@Valid @RequestBody Candidate candidate) {
        return service.saveCandidate(candidate);
    }

    // GET : fectches all candidates
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return service.getAllCandidates();
    }

    // GET : fetch candidate by id
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return service.getCandidateById(id);
    }

    // DELETE : delete candidate by id
    @DeleteMapping("/{id}")
    public String deleteCandidate(Long id) {
        service.deleteCandidate(id);
        return "Candidate Deleted Successfully";
    }

    // POST : add candidates in bulk
    @PostMapping("/bulk")
    public List<Candidate> addCandidates(@Valid @RequestBody List<Candidate> candidates) {
        return service.saveAllCandidates(candidates);
    }

    //GET/SEARCH by name
    @GetMapping("/search")
    public List<Candidate> searchCandidate(@RequestParam String name){
       return service.searchCandidate(name);
    }

    //SEARCH by status
    @GetMapping("/filter")
    public List<Candidate> filterByStatus(@RequestParam CandidateStatus status) {
       return service.filterByStatus(status);
    }
}
