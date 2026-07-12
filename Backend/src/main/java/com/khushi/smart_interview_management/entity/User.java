package com.khushi.smart_interview_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.khushi.smart_interview_management.enums.UserRole;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonPropertyOrder({ "id", "name", "email", "password", "role" })
@Entity // Converts java class into database table
@Table(name = "users") // Used to specify the database table name for an entity.

public class User {

    @Id // "Id" tells that : This field is the Primary Key of the table.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generates the ID automatically (Uses AUTO_INCREMENT)

    private Long id;

    @NotBlank(message="Name cannot be empty")
    private String name;

    @Email(message="Enter valid email")
    @NotBlank(message="Email is required")
    private String email;

    @NotBlank(message="Password is required")
    private String password;

    @NotNull(message="Role is required")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters & Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
