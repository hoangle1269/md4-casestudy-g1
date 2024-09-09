package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InstructorId;

    @OneToOne(cascade = CascadeType.ALL)
    private AppUser InstructorUser;

    @ManyToOne
    private Classroom Classroom;
}
