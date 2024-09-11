package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.FeeStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


public class PaymentDTO {
    private Long feeId;
    private BigDecimal totalAmount;
    private FeeStatus feeStatus;
    private LocalDate dueDate;
    private Long paymentId;
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;

    public PaymentDTO() {
    }

    public PaymentDTO(Long feeId, BigDecimal totalAmount, FeeStatus feeStatus, LocalDate dueDate, Long paymentId, LocalDate paymentDate, BigDecimal paymentAmount) {
        this.feeId = feeId;
        this.totalAmount = totalAmount;
        this.feeStatus = feeStatus;
        this.dueDate = dueDate;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public Long getFeeId() {
        return feeId;
    }

    public void setFeeId(Long feeId) {
        this.feeId = feeId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public FeeStatus getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(FeeStatus feeStatus) {
        this.feeStatus = feeStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
