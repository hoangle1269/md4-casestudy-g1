package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.User;
import lombok.Data;

@Data
public class TeacherStudentCountDTO {
    private Long teacherId;
    private User teacherName;
    private Classes className;
    private Long numberOfStudents;

    public TeacherStudentCountDTO(Long teacherId, User teacherName, Classes className, Long numberOfStudents) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.className = className;
        this.numberOfStudents = numberOfStudents;
    }
    @Override
    public String toString() {
        return "TeacherStudentCountDTO{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", className='" + className + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}
