/*package com.khushi.smart_interview_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.khushi.smart_interview_management.entity.Interview;
import com.khushi.smart_interview_management.enums.CandidateStatus;

public interface InterviewRepository extends JpaRepository<Interview,Long>{
    long countByStatus(Status status);
}*/

package com.khushi.smart_interview_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khushi.smart_interview_management.entity.Interview;
import com.khushi.smart_interview_management.enums.InterviewStatus;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

    long countByStatus(InterviewStatus status);

}