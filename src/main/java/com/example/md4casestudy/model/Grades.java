package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // This handles auto-increment
    @Column(name = "grade_id")
    private Long gradeId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "theory_grade")
    private double theoryGrade;

    @Column(name = "practical_grade")
    private double practicalGrade;

    @Column(name = "average_grade")
    private double averageGrade;
}
