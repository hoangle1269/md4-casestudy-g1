package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IClassRepos extends JpaRepository<Classes,Long> {
    List<Classes> findByLecturer_LecturerId(Long lecturerId);


}
