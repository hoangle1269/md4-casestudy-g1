package com.example.md4casestudy.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String identity;


}
