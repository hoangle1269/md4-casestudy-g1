package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

//Chứa nhật ký hàng ngày cho lớp học và học viên.
@Entity
@Data
@Table(name = "attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes aClasses;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    private String content;//Noi dung Nhat ky
}
