package com.example.md4casestudy.service;

import com.example.md4casestudy.model.Grades;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
    Grades updateGrades(Grades grade);

}