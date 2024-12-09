package com.example.md4casestudy.service.payment;

import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.model.Payment;
import com.example.md4casestudy.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Iterable<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return null;
    }

    @Override
    public void save(Payment payment) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Grades updateGrades(Grades grade) {
        return null;
    }

    @Override
    public Iterable<Payment> findByStudentId(Long studentId) {
        return paymentRepository.findByStudentId(studentId);
    }
}
