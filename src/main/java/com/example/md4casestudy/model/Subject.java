package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

//Chứa thông tin về các môn học.
@Entity
@Data
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
}
