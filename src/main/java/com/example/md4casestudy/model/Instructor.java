package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InstructorId;

    private String email;
    private String password;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String identity;

}
