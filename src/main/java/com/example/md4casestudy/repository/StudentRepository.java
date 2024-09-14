package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.dto.StudentAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentIdDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new com.example.md4casestudy.model.dto.StudentIdDTO(s, s.user.email, s.studentId) FROM Student s WHERE s.className.classId = :classId")
    List<StudentIdDTO> listStudent(@Param("classId") Long classId);

}
