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
    private int logId;

    @ManyToOne
    @JoinColumn(name = "classId")
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    private LocalDate date;
    private String content;//Noi dung Nhat ky
}
