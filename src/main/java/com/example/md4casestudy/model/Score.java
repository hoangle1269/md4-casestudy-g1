package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

//Chứa thông tin về điểm số của học viên.
@Entity
@Data
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    @Column(name = "exam_period")
    private Integer examPeriod;
    private BigDecimal theoryGrade;//diem ly thuyet,số thụ double
    private BigDecimal practicalGrade;//diem thuc hanh
}

