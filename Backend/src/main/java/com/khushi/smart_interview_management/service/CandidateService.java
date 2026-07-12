package com.khushi.smart_interview_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.enums.CandidateStatus;
import com.khushi.smart_interview_management.repository.CandidateRepository;

@Service      //This class contains business logic
public class CandidateService {

    @Autowired     //Create the object automatically and inject it here
    private CandidateRepository repository;

    //POST/SAVE candidate
    public Candidate saveCandidate(Candidate candidate){       
        return repository.save(candidate);
    }

    //GET all candidates
    public List<Candidate> getAllCandidates(){       
        return repository.findAll();
    }

    //GET candidate by id
    public Candidate getCandidateById(Long id){        
        return repository.findById(id).orElse(null);
    }

    //DELETE candidate by id
    public void deleteCandidate(Long id){        
        repository.deleteById(id);
    }

    //BULK adding of candidates
    public List<Candidate> saveAllCandidates(
        List<Candidate> candidates) {
        return repository.saveAll(candidates);
    }

    //SEARCH by name
    public List<Candidate> searchCandidate(String name){
       return repository.findByNameContainingIgnoreCase(name);
    }

    //SEARCH by status
    public List<Candidate> filterByStatus(CandidateStatus status) {
       return repository.findByStatus(status);
    }
}
