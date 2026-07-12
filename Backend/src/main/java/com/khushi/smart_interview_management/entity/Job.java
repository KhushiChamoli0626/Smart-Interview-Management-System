package com.khushi.smart_interview_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@JsonPropertyOrder({ "id", "title", "description", "location" })
@Entity       //Converts java class into database table
@Table(name="jobs")      //Used to specify the database table name for an entity
public class Job {
    
    @Id      //"Id" tells that : This field is the Primary Key of the table
    @GeneratedValue(strategy=GenerationType.IDENTITY)        //Generates the ID automatically  (Uses AUTO_INCREMENT)

    private Long id;

    @NotBlank(message="Job title required")
    private String title;

    @NotBlank(message="Description required")
    private String description;

    @NotBlank(message="Location required")
    private String location;

    //Default Constructor
    public Job(){    
    }

    //GETTERS & SETTERS
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }
}
