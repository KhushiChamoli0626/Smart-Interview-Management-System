/*package com.khushi.smart_interview_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khushi.smart_interview_management.entity.Feedback;

import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query("SELECT AVG(f.overallScore) FROM Feedback f")
    Double getAverageOverallScore();
}*/

package com.khushi.smart_interview_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khushi.smart_interview_management.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query("SELECT AVG(f.overallScore) FROM Feedback f")
    Double getAverageOverallScore();

}
