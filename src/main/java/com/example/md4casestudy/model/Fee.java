package com.example.md4casestudy.model;


import com.example.md4casestudy.model.enums.FeeStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "fee")
//Chứa thông tin về học phí của học viên.
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feeId;

//    @ManyToOne
//    @JoinColumn(name = "student_id", nullable = false)
//    private Student student;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeeStatus status;

    private LocalDate dueDate;
}
