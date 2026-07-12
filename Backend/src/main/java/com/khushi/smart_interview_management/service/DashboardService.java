/*package com.khushi.smart_interview_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.dto.DashboardResponse;
import com.khushi.smart_interview_management.repository.CandidateRepository;
import com.khushi.smart_interview_management.repository.FeedbackRepository;
import com.khushi.smart_interview_management.repository.InterviewRepository;
import com.khushi.smart_interview_management.repository.JobRepository;
import com.khushi.smart_interview_management.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    public DashboardResponse getDashboard() {

        DashboardResponse dashboard = new DashboardResponse();
        dashboard.setTotalUsers(userRepository.count());
        dashboard.setTotalJobs(jobRepository.count());
        dashboard.setTotalCandidates(candidateRepository.count());
        dashboard.setTotalInterviews(interviewRepository.count());
        dashboard.setTotalFeedbacks(feedbackRepository.count());
        dashboard.setAppliedCandidates(candidateRepository.countByStatus("APPLIED"));
        dashboard.setShortlistedCandidates(candidateRepository.countByStatus("SHORTLISTED"));
        dashboard.setInterviewScheduledCandidates(candidateRepository.countByStatus("INTERVIEW_SCHEDULED"));
        dashboard.setHiredCandidates(candidateRepository.countByStatus("HIRED"));
        dashboard.setRejectedCandidates(candidateRepository.countByStatus("REJECTED"));
        dashboard.setCompletedInterviews(interviewRepository.countByStatus("COMPLETED"));
        dashboard.setScheduledInterviews(interviewRepository.countByStatus("SCHEDULED"));
        dashboard.setAverageOverallScore(feedbackRepository.getAverageOverallScore());

        return dashboard;
    }
}*/

package com.khushi.smart_interview_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khushi.smart_interview_management.dto.DashboardResponse;
import com.khushi.smart_interview_management.enums.CandidateStatus;
import com.khushi.smart_interview_management.enums.InterviewStatus;
import com.khushi.smart_interview_management.repository.CandidateRepository;
import com.khushi.smart_interview_management.repository.FeedbackRepository;
import com.khushi.smart_interview_management.repository.InterviewRepository;
import com.khushi.smart_interview_management.repository.JobRepository;
import com.khushi.smart_interview_management.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    public DashboardResponse getDashboard() {

        DashboardResponse dashboard = new DashboardResponse();

        // Totals
        dashboard.setTotalUsers(userRepository.count());
        dashboard.setTotalJobs(jobRepository.count());
        dashboard.setTotalCandidates(candidateRepository.count());
        dashboard.setTotalInterviews(interviewRepository.count());
        dashboard.setTotalFeedbacks(feedbackRepository.count());

        // Candidate Status
        dashboard.setAppliedCandidates(
                candidateRepository.countByStatus(CandidateStatus.APPLIED));

        dashboard.setShortlistedCandidates(
                candidateRepository.countByStatus(CandidateStatus.SHORTLISTED));

        dashboard.setInterviewScheduledCandidates(
                candidateRepository.countByStatus(CandidateStatus.INTERVIEW_SCHEDULED));

        dashboard.setHiredCandidates(
                candidateRepository.countByStatus(CandidateStatus.HIRED));

        dashboard.setRejectedCandidates(
                candidateRepository.countByStatus(CandidateStatus.REJECTED));

        // Interview Status
        dashboard.setScheduledInterviews(
                interviewRepository.countByStatus(InterviewStatus.SCHEDULED));

        dashboard.setCompletedInterviews(
                interviewRepository.countByStatus(InterviewStatus.COMPLETED));

        // Average Feedback Score
        Double avg = feedbackRepository.getAverageOverallScore();

        if (avg == null) {
           dashboard.setAverageOverallScore(0.0);
        } 
        else {
           dashboard.setAverageOverallScore(Math.round(avg * 100.0) / 100.0);
        }
        return dashboard;
    }
}
