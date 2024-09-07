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
    private int subjectId;

    private String subjectName;
}
