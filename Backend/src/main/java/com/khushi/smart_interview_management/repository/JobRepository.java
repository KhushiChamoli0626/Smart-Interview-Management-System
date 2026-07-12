package com.khushi.smart_interview_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;       // API/specification for database persistence
import com.khushi.smart_interview_management.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTitleContainingIgnoreCase(String title);
}
