package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;


//Chứa thông tin về các lớp học.
@Entity
@Data
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    private String className;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


}
