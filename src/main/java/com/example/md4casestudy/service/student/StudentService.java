package com.example.md4casestudy.service.student;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.dto.StudentIdDTO;
import com.example.md4casestudy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void flush() {

    }


    public <S extends Student> long count(Example<S> example) {
        return 0;
    }

    public <S extends Student> boolean exists(Example<S> example) {
        return false;
    }


    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public long count() {
        return 0;
    }


    public void delete(Student entity) {

    }


    public List<StudentIdDTO> listStudent(Long classId) {
        return studentRepository.listStudent(classId);
    }
}
