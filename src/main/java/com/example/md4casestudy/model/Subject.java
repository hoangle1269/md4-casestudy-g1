package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

//Chứa thông tin về các môn học.
@Entity
@Data
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_name")
    private String subjectName;
}
