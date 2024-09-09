package com.example.md4casestudy.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

//Chứa thông tin chung về người dùng trong hệ thống.
@Entity
@Data
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String phoneNumber;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String identity;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;


}
