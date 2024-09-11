package com.example.md4casestudy.service;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void updateStatus(Long studentId, STUDENT_STATUS newStatus) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStatus(newStatus);
        studentRepository.save(student);
    }

    public List<Student> getAllStudentsByClass(Long classId) {
        return studentRepository.findAllByClasses_ClassId(classId);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }



}