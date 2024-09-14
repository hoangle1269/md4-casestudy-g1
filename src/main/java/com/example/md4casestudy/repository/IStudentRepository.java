package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByClasses_ClassName(String className);

    List<Student> findByClasses_ClassId(Long classId);

    List<Student> findByClasses_ClassIdAndStatus(Long classId, STUDENT_STATUS status);

}