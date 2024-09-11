package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.DTO.PaymentDTO;
import com.example.md4casestudy.repository.IPaymentHistoryRepository;
import com.example.md4casestudy.service.implFee.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class PaymentHistoryController {


        @Autowired
        private IPaymentHistoryRepository iPaymentHistoryRepository;

        @GetMapping("/student/{studentId}/payments")
        public String getPaymentHistory(@PathVariable Long studentId, Model model) {
            List<PaymentDTO> paymentHistory = iPaymentHistoryRepository.findPaymentHistoryByStudentId(studentId);
            model.addAttribute("paymentHistory", paymentHistory);
            return "payment/paymentHistory";
        }
    }

