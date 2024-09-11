package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.FeeStatus;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Data
public class FeeDTO {
    private Long feeId;
    private Long studentId;
    private BigDecimal amount;
    private FeeStatus status;
    private Date dueDate;
}
