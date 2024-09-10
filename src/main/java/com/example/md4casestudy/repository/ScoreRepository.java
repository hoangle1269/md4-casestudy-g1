package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    Optional<Score> findByStudent_StudentIdAndSubject_SubjectId(Long studentId, Long subjectId);


    List<Score> findByStudent_StudentId(Long studentId);


}
