package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

//Chứa thông tin về điểm số của học viên.
@Entity
@Data
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;

    private BigDecimal theoryGrade;//diem ly thuyet,số thục  giong double
    private BigDecimal practicalGrade;//diem thuc hanh


}

