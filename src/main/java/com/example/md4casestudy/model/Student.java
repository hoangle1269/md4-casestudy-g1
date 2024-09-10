package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

//Chứa thông tin về học viên.
@Entity
@Data
@Table(name = "student")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "student_id")
        private Long studentId;

        @Column(name = "full_name", nullable = false)
        private String fullName;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "date_of_birth", nullable = false)
        private LocalDate dateOfBirth;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", nullable = false)
        private StudentStatus status;

        @ManyToOne
        @JoinColumn(name = "class_id")
        private Class aClass;

        @OneToMany(mappedBy = "student")
        private Set<Score> scores;

        @OneToMany(mappedBy = "student")
        private Set<Fee> fees;
}
