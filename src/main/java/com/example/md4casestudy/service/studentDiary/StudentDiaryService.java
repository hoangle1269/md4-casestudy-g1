package com.example.md4casestudy.service.studentDiary;

import com.example.md4casestudy.model.StudentDiary;
import com.example.md4casestudy.repository.IStudentDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDiaryService implements IStudentDiaryService{

    @Autowired
    private IStudentDiaryRepository studentDiaryRepository;

    @Override
    public List<StudentDiary> findByStudentId(Long studentId) {
        return studentDiaryRepository.findByStudent_StudentId(studentId);
    }

    @Override
    public Iterable<StudentDiary> findAll() {
        return null;
    }

    @Override
    public void save(StudentDiary studentDiary) {
        studentDiaryRepository.save(studentDiary);
    }

    @Override
    public Optional<StudentDiary> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
        studentDiaryRepository.deleteById(id);
    }


    @Override
    public List<StudentDiary> findAllByStudentId(Long studentId) {
        return studentDiaryRepository.findByStudent_StudentId(studentId);
    }



}