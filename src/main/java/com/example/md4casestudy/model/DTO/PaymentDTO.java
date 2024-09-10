package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.Fee;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

@Data
public class PaymentDTO {
    private Long paymentId;
    private Long feeId;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
}