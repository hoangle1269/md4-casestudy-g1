package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

//    List<Student> findAllByFullNameContainingIgnoreCase(String fullName);



}
