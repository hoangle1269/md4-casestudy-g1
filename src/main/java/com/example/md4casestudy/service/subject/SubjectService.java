package com.example.md4casestudy.service.subject;

import com.example.md4casestudy.model.Subject;
import com.example.md4casestudy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}