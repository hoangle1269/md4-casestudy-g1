package com.example.md4casestudy.model;


import com.example.md4casestudy.model.ENUM.FEE_STATUS;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "fees")
//Chứa thông tin về học phí của học viên.
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id")
    private Long feeId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FEE_STATUS status;

    @Column(name = "due_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate dueDate;
}
