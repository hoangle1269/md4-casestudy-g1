package com.example.md4casestudy.service.studentDiary;

import com.example.md4casestudy.model.StudentDiary;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;

public interface IStudentDiaryService extends IGenerateService<StudentDiary> {
    List<StudentDiary> findByStudentId(Long studentId);

    void save(StudentDiary studentDiary);

    List<StudentDiary> findAllByStudentId(Long studentId);

}
