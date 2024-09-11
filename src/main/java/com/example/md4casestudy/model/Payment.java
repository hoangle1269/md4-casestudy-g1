package com.example.md4casestudy.model;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate paymentDate;

    private Double paymentAmount;

    @ManyToOne
    private Student student;
}
