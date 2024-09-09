package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturerId;

    @Column(unique = true, nullable = false)    //Có giá trị duy nhất ko trùng lặp và ko null
    private String email;

    private String password;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String identity;

}
