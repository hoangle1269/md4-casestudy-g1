package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


//Chứa thông tin về các lớp học.
@Entity
@Data
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "class_name")
    private String className;

    @OneToMany(mappedBy = "aClass")
    private Set<Student> students;
}
