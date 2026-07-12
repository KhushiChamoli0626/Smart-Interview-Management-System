package com.khushi.smart_interview_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository; // API/specification for database persistence
import com.khushi.smart_interview_management.entity.User;

import com.khushi.smart_interview_management.enums.UserRole;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(UserRole role);
    Optional<User> findByEmail(String email);
}
