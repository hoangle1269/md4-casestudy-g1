package com.example.md4casestudy.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emailId;

    private String recipient;
    private String subject;
    private String body;
    private LocalDate sentDate;

    // Getters and Setters
}
