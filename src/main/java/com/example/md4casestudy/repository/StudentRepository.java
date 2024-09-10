package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByClasses_ClassName(String className);

    List<Student> findAllByClasses_ClassId(Long classId);

}