package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gradeid")
    private Long gradeId;
    @ManyToOne
    @JoinColumn(name = "studentid", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subjectid", nullable = false)
    private Subject subject;

    @Column(name = "theorygrade")
    private double theoryGrade;

    @Column(name = "practicalgrade")
    private double practicalGrade;

    @Column(name = "averagegrade")
    private double averageGrade;
}
