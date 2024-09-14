package com.example.md4casestudy.model;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//Chứa thông tin về học viên.
@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @OneToOne(cascade = CascadeType.ALL)
    private User studentUser;

    @Enumerated(EnumType.STRING)
    private STUDENT_STATUS status;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    @OneToMany(mappedBy = "student")
    private Set<Score> scores; // Liên kết đến điểm số

    @OneToMany(mappedBy = "student")
    private Set<Fee> fees; // Liên kết đến học phí
    // Getters and Setters
}
