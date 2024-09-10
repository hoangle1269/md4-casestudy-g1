package com.example.md4casestudy.model.dto;

import lombok.Data;

@Data
public class TeacherStudentCountDTO {
    private Long teacherId;
    private String teacherName;
    private String className;
    private Long numberOfStudents;

    public TeacherStudentCountDTO(Long teacherId, String teacherName, String className, Long numberOfStudents) {
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
