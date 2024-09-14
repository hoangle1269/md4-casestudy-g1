package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Payment;
import com.example.md4casestudy.service.fee.IFeeService;
import com.example.md4casestudy.service.payment.IPaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classes/students/fees")
public class FeeController {
    private final IFeeService feeService;
    private final IPaymentService paymentService;
    public FeeController(IFeeService feeService, IPaymentService paymentService) {
        this.feeService = feeService;
        this.paymentService = paymentService;
    }

    @GetMapping("/{studentId}")
    public String getFeeStatus(Model model, @PathVariable("studentId") Long studentId) {
        List<Fee> fees = feeService.findByStudent(studentId);
        Iterable<Payment> payments = paymentService.findByStudentId(studentId);
        model.addAttribute("fees", fees);
        model.addAttribute("payments", payments);
        return "fee/view";
    }


}