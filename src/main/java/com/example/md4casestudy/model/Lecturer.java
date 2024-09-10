package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lecturers")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturerId;



    @OneToOne(cascade = CascadeType.ALL)
    private User lecturerUser;

}
