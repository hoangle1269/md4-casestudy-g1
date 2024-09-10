package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
