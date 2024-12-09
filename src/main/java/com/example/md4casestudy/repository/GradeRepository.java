package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.model.dto.ClassAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentAverageGradeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grades, Long> {
    @Query("SELECT new com.example.md4casestudy.model.dto.ClassAverageGradeDTO(g.student.className,AVG(g.averageGrade)) FROM Grades g GROUP BY g.student.className.classId")
    List<ClassAverageGradeDTO> findAverageGradesByClass();

    @Query("SELECT new com.example.md4casestudy.model.dto.StudentAverageGradeDTO(s.className,s.user, AVG(g.averageGrade)) FROM Student s JOIN Grades g ON s.studentId = g.student.studentId GROUP BY s.className.classId, s.studentId")
    List<StudentAverageGradeDTO> findAverageGradesByStudent();

    @Query("SELECT new  com.example.md4casestudy.model.dto.StudentAverageGradeDTO(s.className, s.user,AVG(g.averageGrade),s) FROM Student s JOIN Grades g ON s.studentId = g.student.studentId WHERE s.className.classId = :classId GROUP BY s.className.classId, s.studentId")
    List<StudentAverageGradeDTO> findAverageGradesByClassId(@Param("classId") Long classId);




}
