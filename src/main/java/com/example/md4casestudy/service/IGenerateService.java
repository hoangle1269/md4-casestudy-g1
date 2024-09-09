package com.example.md4casestudy.service;

import com.example.md4casestudy.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenerateService<T> {
    Page<T> findAll(Pageable pageable);
}
