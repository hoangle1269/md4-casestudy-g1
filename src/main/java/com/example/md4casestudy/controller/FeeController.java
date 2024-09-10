package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.service.impl.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private IFeeService feeService;

    @GetMapping("/next/{studentId}")
    public String getNextFee(@PathVariable Long studentId, Model model) {
        FeeDTO feeDTO = feeService.getNextFee(studentId);
        model.addAttribute("feeDTO", feeDTO);
        return "fee/next-fee";
    }
}