package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
}
