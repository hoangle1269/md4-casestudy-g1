package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IScoreRepository extends JpaRepository<Score,Long> {
    @Query(value = "CALL GetScoresByStudentAndExamPeriod(:studentId)", nativeQuery = true)
    List<Object[]> findStudentScores(@Param("studentId") Long studentId);
}
