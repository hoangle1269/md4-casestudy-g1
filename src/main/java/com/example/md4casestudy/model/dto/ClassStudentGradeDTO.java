package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.*;

public class ClassStudentGradeDTO {

    private Classes className;
    private Student studentName;
    private Subject subjectName;
    private Grades grade;

    public ClassStudentGradeDTO() {
    }

    public ClassStudentGradeDTO(Classes className, Student studentName, Subject subjectName, Grades grade) {
        this.className = className;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.grade = grade;
    }

    public Classes getClassName() {
        return className;
    }

    public void setClassName(Classes className) {
        this.className = className;
    }

    public Student getStudentName() {
        return studentName;
    }

    public void setStudentName(Student studentName) {
        this.studentName = studentName;
    }

    public Subject getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(Subject subjectName) {
        this.subjectName = subjectName;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ClassStudentGradeDTO{" +
                "className=" + className +
                ", studentName=" + studentName +
                ", subjectName=" + subjectName +
                ", grade=" + grade +
                '}';
    }
}