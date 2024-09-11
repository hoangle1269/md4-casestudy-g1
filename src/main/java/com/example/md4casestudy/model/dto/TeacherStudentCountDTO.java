package com.example.md4casestudy.model.dto;

public class TeacherStudentCountDTO {
    private Long teacherId;
    private String teacherName;
    private String className;
    private Long numberOfStudents;

    // Constructor
    public TeacherStudentCountDTO(Long teacherId, String teacherName, String className, Long numberOfStudents) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.className = className;
        this.numberOfStudents = numberOfStudents;
    }

    // Getters and Setters
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Long numberOfStudents) {
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
