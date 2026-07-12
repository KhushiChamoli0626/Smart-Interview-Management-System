package com.khushi.smart_interview_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.khushi.smart_interview_management.enums.CandidateStatus;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder({ "id", "name", "email", "phone", "status" })
@Entity // Converts java class into database table
@Table(name = "candidates") // Used to specify the database table name for an entity
public class Candidate {

    @Id // "Id" tells that : This field is the Primary Key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generates the ID automatically (Uses AUTO_INCREMENT)
    private Long id;

    @NotBlank(message="Candidate name is required")
    private String name;

    @NotBlank(message="Invalid email")
    private String email;

    @NotBlank(message="Phone is required")
    private String phone;

    @NotNull(message="Status is required")
    @Enumerated(EnumType.STRING)
    private CandidateStatus status;

    private String resumeFileName;

    // Default Constructor
    public Candidate() {
    }

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CandidateStatus getStatus() {
        return status;
    }

    public void setStatus(CandidateStatus status) {
        this.status = status;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
       this.resumeFileName = resumeFileName;
    }

    
}
