package com.example.md4casestudy.model;

import com.example.md4casestudy.model.ENUM.ROLE;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, max = 8)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String address;
    private String identity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ROLE role;



}
