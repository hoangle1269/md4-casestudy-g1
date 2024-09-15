package com.example.md4casestudy.service.classes;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<Classes> listClass() {
        return classRepository.findAll();
    }

    public Classes findById(Long id) {
        return classRepository.findById(id).orElse(null);
    }
}
