package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.FeeStatus;
import com.example.md4casestudy.model.Student;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class FeeDTO {
private Long feeId;
private Student student;
private BigDecimal amount;
private FeeStatus status;
private LocalDate dueDate;
}
