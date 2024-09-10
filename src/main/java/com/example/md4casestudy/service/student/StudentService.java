package com.example.md4casestudy.service.student;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

@Autowired
private IStudentRepository iStudentRepository;




    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllByClassName(String className) {
        return iStudentRepository.findAllByClasses_ClassName(className);
    }
}
