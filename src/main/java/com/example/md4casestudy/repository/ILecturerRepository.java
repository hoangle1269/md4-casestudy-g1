package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILecturerRepository extends JpaRepository<Lecturer,Long> {
}