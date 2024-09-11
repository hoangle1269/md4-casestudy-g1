package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "class_diaries")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes classes;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now(); // Ngày hiện tại sẽ được gán mặc định


    private String content; // Nội dung nhật ký
}
