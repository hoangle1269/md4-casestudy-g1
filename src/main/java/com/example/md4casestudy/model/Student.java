package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//Chứa thông tin về học viên.
@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String fullName;
    private String email;


    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    @OneToMany(mappedBy = "student")
    private Set<Score> scores; // Liên kết đến điểm số

    @OneToMany(mappedBy = "student")
    private Set<Fee> fees; // Liên kết đến học phí
    // Getters and Setters
}
