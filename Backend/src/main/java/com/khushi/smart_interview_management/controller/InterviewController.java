package com.khushi.smart_interview_management.controller;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.khushi.smart_interview_management.entity.Interview;
import com.khushi.smart_interview_management.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    @Autowired
    private InterviewService service;

    // POST : save interview
    @PostMapping
    public Interview addInterview(@Valid @RequestBody Interview interview) {
        return service.saveInterview(interview);
    }

    // GET : fetch all interviews
    @GetMapping
    public List<Interview> getAllInterviews() {
        return service.getAllInterviews();
    }

    // GET : fetch interview by id
    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable Long id) {
        return service.getInterviewById(id);
    }

    // DELETE : deletes interview by id
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "Interview deleted successfully";
    }

    @PostMapping("/bulk")
    public List<Interview> addInterviews(@Valid @RequestBody List<Interview> interviews) {
        return interviews.stream().map(service::saveInterview).toList();
    }
}
