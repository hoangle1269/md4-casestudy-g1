package com.example.md4casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String home() {
        return "login";
    }

    // Trang đăng nhập
    @GetMapping("/logout")
    public String login() {
        return "logout";
    }

    // Trang đăng ký
//    @GetMapping("/register")
//    public String register() {
//        return "register";
//    }
//
//    // Trang lỗi 404
//    @GetMapping("/error_404")
//    public String error404() {
//        return "error_404";
//    }

//    @GetMapping("/staff")
//    public String staff() {
//        return "staff/staff-view";
//    }

}
