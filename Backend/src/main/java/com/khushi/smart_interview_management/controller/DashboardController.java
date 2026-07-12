/*package com.khushi.smart_interview_management.controller;

import com.khushi.smart_interview_management.dto.DashboardResponse;
import com.khushi.smart_interview_management.repository.CandidateRepository;
import com.khushi.smart_interview_management.repository.FeedbackRepository;
import com.khushi.smart_interview_management.repository.InterviewRepository;
import com.khushi.smart_interview_management.repository.JobRepository;
import com.khushi.smart_interview_management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalUsers(userRepository.count());
        response.setTotalCandidates(candidateRepository.count());
        response.setTotalJobs(jobRepository.count());
        response.setTotalInterviews(interviewRepository.count());
        response.setTotalFeedbacks(feedbackRepository.count());

        return response;
    }
}*/

package com.khushi.smart_interview_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khushi.smart_interview_management.dto.DashboardResponse;
import com.khushi.smart_interview_management.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getDashboard() {
        return dashboardService.getDashboard();
    }

}
