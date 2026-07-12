package com.khushi.smart_interview_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.khushi.smart_interview_management.enums.Recommendation;

@JsonPropertyOrder({ "id", "interview", "communicationScore", "problemSolvingScore", "technicalScore", "overallScore",
        "remarks", "recommendation" })
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "interview_id")
    @NotNull(message = "Interview is required")
    private Interview interview;

    @Column(nullable = false)
    @NotNull(message="Technical score required")
    @DecimalMin(value="0.0")
    @DecimalMax(value="10.0")
    private Double technicalScore;

    @Column(nullable = false)
    @NotNull(message="Communication score required")
    @DecimalMin(value="0.0")
    @DecimalMax(value="10.0")
    private Double communicationScore;

    @Column(nullable = false)
    @NotNull(message="Problem Solving score required")
    @DecimalMin(value="0.0")
    @DecimalMax(value="10.0")
    private Double problemSolvingScore;

    @Column(nullable = false)
    @NotNull(message = "Overall score required")
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    private Double overallScore;

    @Column(length = 500)
    private String remarks;

    @Column(nullable = false)
    @NotNull(message="Recommendation required")
    @Enumerated(EnumType.STRING)
    private Recommendation recommendation;

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Double getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(Double technicalScore) {
        this.technicalScore = technicalScore;
    }

    public Double getCommunicationScore() {
        return communicationScore;
    }

    public void setCommunicationScore(Double communicationScore) {
        this.communicationScore = communicationScore;
    }

    public Double getProblemSolvingScore() {
        return problemSolvingScore;
    }

    public void setProblemSolvingScore(Double problemSolvingScore) {
        this.problemSolvingScore = problemSolvingScore;
    }

    public Double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Recommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Recommendation recommendation) {
        this.recommendation = recommendation;
    }
}
