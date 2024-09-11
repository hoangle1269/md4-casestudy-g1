package com.example.md4casestudy.service.student;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;

public interface IStudentService extends IGenerateService<Student> {
//    List<Student> findAllByFullNameContainingIgnoreCase(String fullName);

    List<Student> findAllByClassName(String className);

    List<Student> findByClassId(Long classId);


    List<Student> findStudentsByClassIdAndStatus(Long classId, STUDENT_STATUS status);
}
