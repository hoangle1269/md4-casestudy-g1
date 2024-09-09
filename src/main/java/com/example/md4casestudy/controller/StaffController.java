package com.example.md4casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @GetMapping("")
    public String staffHome() {
        return "staff/home";
    }

    @GetMapping("/reports")
    public String staffReports() {
        return "staff/reports";
    }
}
