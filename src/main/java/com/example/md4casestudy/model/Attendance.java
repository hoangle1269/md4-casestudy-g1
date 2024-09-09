package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

//Chứa nhật ký hàng ngày cho lớp học và học viên.
@Entity
@Data
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    private LocalDate date;
    private String content;//Noi dung Nhat ky
}
