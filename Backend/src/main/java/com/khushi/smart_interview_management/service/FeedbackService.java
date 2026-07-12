package com.khushi.smart_interview_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.entity.Feedback;
import com.khushi.smart_interview_management.repository.FeedbackRepository;

@Service
public class FeedbackService {
    
    @Autowired
    private FeedbackRepository repository;

    //POST/SAVE feedbacks
    public Feedback saveFeedback(Feedback feedback){
        return repository.save(feedback);
    }

    //GET all feedbacks
    public List<Feedback> getAllFeedbacks(){
        return repository.findAll();
    }

    //GET feedbacks by id
    public Feedback getFeedbackById(Long id){
        return repository.findById(id).orElse(null);
    }

    //DELETE feedbacks by id
    public String deleteById(Long id){
        repository.deleteById(id);
        return "Feedback deleted Successfully";
    }

    //POST/SAVE feedbacks in bulk
    public List<Feedback> saveAllFeedbacks(List<Feedback> feedbackList){
        return repository.saveAll(feedbackList);
    }
}
