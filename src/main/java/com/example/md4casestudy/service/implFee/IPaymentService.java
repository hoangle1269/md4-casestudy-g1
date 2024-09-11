package com.example.md4casestudy.service.implFee;

import com.example.md4casestudy.model.DTO.PaymentDTO;
import com.example.md4casestudy.model.DTO.ScoreDTO;

import java.util.List;

public interface IPaymentService {
    List<PaymentDTO> getPaymentHistoryByStudentId (Long studentId);
}

