package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.service.implFee.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FeeController {

    @Autowired
    private IFeeService feeService;

    @GetMapping("/student/{studentId}/fees")
    public String getAllFeeStatus(@PathVariable("studentId") Long studentId, Model model) {
        List<FeeDTO> fees = feeService.getAllFeeStatus(studentId);
        model.addAttribute("fees", fees);
        return "/fee/feeView";
    }
}
