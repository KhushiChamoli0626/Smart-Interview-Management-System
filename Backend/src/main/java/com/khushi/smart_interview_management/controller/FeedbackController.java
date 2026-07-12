package com.khushi.smart_interview_management.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.khushi.smart_interview_management.entity.Feedback;
import com.khushi.smart_interview_management.service.FeedbackService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    //POST/SAVE : save feedbacks
    @PostMapping
    public Feedback saveFeedback(@Valid @RequestBody Feedback feedback){
        return service.saveFeedback(feedback);
    }

    //GET : fetches all feedbacks
    @GetMapping
    public List<Feedback> getAllFeedbacks(){
        return service.getAllFeedbacks();
    }

    //GET : fetch feedback by id
    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Long id){
        return service.getFeedbackById(id);
    }

    //DELETE : delete feedback by id
    @DeleteMapping("/{id}")
    public String deleteFeedbackById(@PathVariable Long id){
        service.deleteById(id);
        return "Feedback deleted successfully";
    }

    //POST : add feedbacks in bulk
    @PostMapping("/bulk")
    public List<Feedback> addFeedbacks(@Valid @RequestBody List<Feedback> feedbackList){
        return service.saveAllFeedbacks(feedbackList);
    }
}