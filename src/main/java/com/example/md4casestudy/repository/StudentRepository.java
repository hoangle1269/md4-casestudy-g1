package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.dto.StudentIdDTO;
import com.example.md4casestudy.model.dto.StudentScoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByClasses_ClassName(String className);

    List<Student> findAllByClasses_ClassId(Long classId);

//    @Query("SELECT s.studentId AS studentId, s.fullName AS fullName, s.email AS email, " +
//            "c.className AS className, sc.theoryScore AS theoryScore, sc.practicalScore AS practicalScore, s.status AS status " +
//            "FROM Student s " +
//            "JOIN s.classes c " +
//            "LEFT JOIN s.scores sc " +
//            "ORDER BY s.studentId")
//    List<StudentScoreDTO> findAllStudentScores();

    @Query("SELECT new com.example.md4casestudy.model.dto.StudentIdDTO(s, s.studentUser.email, s.studentId) FROM Student s WHERE s.classes.classId = :classId")
    List<StudentIdDTO> listStudent(@Param("classId") Long classId);

}