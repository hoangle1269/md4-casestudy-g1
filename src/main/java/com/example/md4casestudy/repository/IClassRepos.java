package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClassRepos extends JpaRepository<Classes,Long> {



}
