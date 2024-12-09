package com.example.md4casestudy.service.payment;

import com.example.md4casestudy.model.Payment;
import com.example.md4casestudy.service.IGenerateService;

import java.util.Optional;

public interface IPaymentService extends IGenerateService<Payment> {
    Iterable<Payment> findByStudentId(Long studentId);
}
