package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Class;
import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;

public class StudentAverageGradeDTO {

    private Class classes;
    private User students;
    private Double averageGrade;

    public StudentAverageGradeDTO(Class classes, User students, Double averageGrade) {
        this.classes = classes;
        this.students = students;
        this.averageGrade = averageGrade;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
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

    @Override
    public String toString() {
        return "StudentAverageGradeDTO{" +
                "classId=" + classes +
                ", studentId=" + students +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
