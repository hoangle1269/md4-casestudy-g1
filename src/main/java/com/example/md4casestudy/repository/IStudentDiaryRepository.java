package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.StudentDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDiaryRepository extends JpaRepository<StudentDiary, Long> {
    List<StudentDiary> findByStudent_StudentId(Long studentId);

}