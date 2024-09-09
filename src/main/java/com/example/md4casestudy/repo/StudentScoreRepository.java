package com.example.md4casestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
    StudentScore findByStudentIdAndSubjectId(Long studentId, Long subjectId);
}