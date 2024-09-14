package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<User,Long> {
}