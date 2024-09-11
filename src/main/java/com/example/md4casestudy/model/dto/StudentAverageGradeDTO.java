package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;

public class StudentAverageGradeDTO {

    private Classes classes;
    private User students;
    private Double averageGrade;
    private Student student;

    public StudentAverageGradeDTO(Classes classes, User students, Double averageGrade) {
        this.classes = classes;
        this.students = students;
        this.averageGrade = averageGrade;
    }

    public StudentAverageGradeDTO(Classes classes, User students, Double averageGrade, Student student) {
        this.classes = classes;
        this.students = students;
        this.averageGrade = averageGrade;
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public User getStudents() {
        return students;
    }

    public void setStudents(User students) {
        this.students = students;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentAverageGradeDTO{" +
                "classId=" + classes +
                ", studentId=" + students +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
