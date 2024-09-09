package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Classes aClasses;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now(); // Ngày hiện tại sẽ được gán mặc định

    @Column(name = "content", nullable = false)
    private String content; // Nội dung nhật ký
}
