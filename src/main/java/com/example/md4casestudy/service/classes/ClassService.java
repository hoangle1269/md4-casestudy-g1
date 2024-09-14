package com.example.md4casestudy.service.classes;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.IClassRepos;
import com.example.md4casestudy.repository.IStudentRepository;
import com.example.md4casestudy.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    private IClassRepos iClassRepos;

    @Autowired
    private IStudentRepository iStudentRepository;


    @Override
    public Iterable<Classes> findAll() {
        return iClassRepos.findAll();
    }

    @Override
    public void save(Classes classes) {
        iClassRepos.save(classes);
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return iClassRepos.findById(id);
    }

    @Override
    public void remove(Long id) {
        iClassRepos.deleteById(id);
    }

    @Override
    public List<Classes> findClassesByLecturerId(Long lecturerId) {
        return iClassRepos.findByLecturer_LecturerId(lecturerId);
    }

    @Override
    public List<Student> findStudentsByClassId(Long classId) {
        return iStudentRepository.findByClasses_ClassId(classId);
    }

}