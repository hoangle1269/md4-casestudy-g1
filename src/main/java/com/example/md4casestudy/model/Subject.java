package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectid")
    private Long subjectId;
@Column(name = "subjectname")
    private String subjectName;
}
