package com.example.md4casestudy.service.classes;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.IClassRepository;
import com.example.md4casestudy.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepository iClassRepository;

    @Autowired
    private IStudentRepository iStudentRepository;


    @Override
    public Iterable<Classes> findAll() {
        return iClassRepository.findAll();
    }

    @Override
    public void save(Classes classes) {
        iClassRepository.save(classes);
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return iClassRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iClassRepository.deleteById(id);
    }

    @Override
    public List<Classes> findClassesByLecturerId(Long lecturerId) {
        return iClassRepository.findByLecturer_LecturerId(lecturerId);
    }

    @Override
    public List<Student> findStudentsByClassId(Long classId) {
        return iStudentRepository.findByClasses_ClassId(classId);
    }



}