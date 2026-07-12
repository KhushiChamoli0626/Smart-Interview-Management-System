package com.khushi.smart_interview_management.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalJobs;
    private long totalCandidates;
    private long totalInterviews;
    private long totalFeedbacks;

    private long appliedCandidates;
    private long shortlistedCandidates;
    private long interviewScheduledCandidates;
    private long hiredCandidates;
    private long rejectedCandidates;

    private long completedInterviews;
    private long scheduledInterviews;

    private Double averageOverallScore;

    public DashboardResponse() {
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalJobs() {
        return totalJobs;
    }

    public long getTotalCandidates() {
        return totalCandidates;
    }

    public long getTotalInterviews() {
        return totalInterviews;
    }

    public long getTotalFeedbacks() {
        return totalFeedbacks;
    }

    public long getAppliedCandidates() {
        return appliedCandidates;
    }

    public long getShortlistedCandidates() {
        return shortlistedCandidates;
    }

    public long getInterviewScheduledCandidates() {
        return interviewScheduledCandidates;
    }

    public long getHiredCandidates() {
        return hiredCandidates;
    }

    public long getRejectedCandidates() {
        return rejectedCandidates;
    }

    public long getCompletedInterviews() {
        return completedInterviews;
    }

    public long getScheduledInterviews() {
        return scheduledInterviews;
    }

    public Double getAverageOverallScore() {
        return averageOverallScore;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public void setTotalCandidates(long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public void setTotalInterviews(long totalInterviews) {
        this.totalInterviews = totalInterviews;
    }

    public void setTotalFeedbacks(long totalFeedbacks) {
        this.totalFeedbacks = totalFeedbacks;
    }

    public void setAppliedCandidates(long appliedCandidates) {
        this.appliedCandidates = appliedCandidates;
    }

    public void setShortlistedCandidates(long shortlistedCandidates) {
        this.shortlistedCandidates = shortlistedCandidates;
    }

    public void setInterviewScheduledCandidates(long interviewScheduledCandidates) {
        this.interviewScheduledCandidates = interviewScheduledCandidates;
    }

    public void setHiredCandidates(long hiredCandidates) {
        this.hiredCandidates = hiredCandidates;
    }

    public void setRejectedCandidates(long rejectedCandidates) {
        this.rejectedCandidates = rejectedCandidates;
    }

    public void setCompletedInterviews(long completedInterviews) {
        this.completedInterviews = completedInterviews;
    }

    public void setScheduledInterviews(long scheduledInterviews) {
        this.scheduledInterviews = scheduledInterviews;
    }

    public void setAverageOverallScore(Double averageOverallScore) {
        this.averageOverallScore = averageOverallScore;
    }
}