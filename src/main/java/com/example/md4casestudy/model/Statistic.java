package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

//Chứa thông tin thống kê về học viên và giảng viên.
@Entity
@Data
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statId;

    @Enumerated(EnumType.STRING)
    private StatisticType type;

    private BigDecimal value;
    private LocalDate date;

    // Getters and Setters
}

