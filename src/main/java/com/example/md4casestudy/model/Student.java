package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

//Chứa thông tin về học viên.
@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String fullName;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    // Getters and Setters
}
