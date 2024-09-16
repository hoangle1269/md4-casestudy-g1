package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.service.appUser.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }

    @PostMapping("/login")
    public void login(@RequestParam("username") String email, @RequestParam("password") String password, HttpSession session) {
        User user = appUserService.findByEmail(email);
        session.setAttribute("user", user);
        System.out.println(user);
        System.out.println("////////////////////////////////////");
        System.out.println(email);
    }

    @GetMapping("/logout")
    public String logout() {

        return "logout";
    }


}
