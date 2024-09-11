package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.service.fee.IFeeService;
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
    public FeeController(IFeeService feeService) {
        this.feeService = feeService;
    }

    @GetMapping("/{studentId}")
    public String getFeeStatus(Model model, @PathVariable("studentId") Long studentId) {
        List<Fee> fees = feeService.findByStudent(studentId);
//        Optional<Fee> fees = feeService.findByStudentId(studentId);
//        if (fees.isPresent()) {
//        }
        model.addAttribute("fees", fees);
        return "fee/view";
    }
}
