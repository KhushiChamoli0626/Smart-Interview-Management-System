/*package com.khushi.smart_interview_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;         // API/specification for database persistence
import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.enums.CandidateStatus;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    long countByStatus(String status);
    List<Candidate> findByNameContainingIgnoreCase(String name);
    List<Candidate> findByStatus(CandidateStatus status);
}*/

package com.khushi.smart_interview_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khushi.smart_interview_management.entity.Candidate;
import com.khushi.smart_interview_management.enums.CandidateStatus;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByNameContainingIgnoreCase(String name);

    List<Candidate> findByStatus(CandidateStatus status);

    long countByStatus(CandidateStatus status);

}


