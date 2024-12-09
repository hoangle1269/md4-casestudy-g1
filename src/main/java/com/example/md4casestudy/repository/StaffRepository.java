package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.ClassStudentGradeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<User,Long> {
    @Query("SELECT new com.example.md4casestudy.model.dto.ClassStudentGradeDTO(c,s,sub,g) FROM Grades g JOIN g.student s JOIN g.subject sub JOIN s.className c WHERE s.studentId = :studentId")
    List<ClassStudentGradeDTO> findClassStudentGradeDetailsByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT new com.example.md4casestudy.model.dto.ClassStudentGradeDTO(s) FROM Student s WHERE s.className.classId = :classId")
    List<ClassStudentGradeDTO> findStudent(@Param("classId") Long classId);
    @Query("SELECT new com.example.md4casestudy.model.dto.ClassStudentGradeDTO(c, s, sub, g) FROM Grades g JOIN g.student s JOIN g.subject sub JOIN s.className c WHERE g.id = :idGrade")
    ClassStudentGradeDTO findClassStudentGradeDetailsByGradeId(@Param("idGrade") Long idGrade);

}
