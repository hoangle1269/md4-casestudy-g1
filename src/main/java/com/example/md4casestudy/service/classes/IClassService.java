package com.example.md4casestudy.service.classes;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;

public interface IClassService extends IGenerateService<Classes> {

     List<Classes> findClassesByLecturerId(Long lecturerId);

    List<Student> findStudentsByClassId(Long classId);

//     List<Student> findStudentsByClassIdAndStatus(Long classId, STUDENT_STATUS status);


}
