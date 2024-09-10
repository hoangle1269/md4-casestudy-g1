package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.model.dto.TeacherStudentCountDTO;
import com.example.md4casestudy.service.appUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AppUserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String homePage() {
        List<TeacherStudentCountDTO> teacherStudentCountDTO = userRepository.findTeacherStudentCounts();
        return "adminPages/index";
    }

    @GetMapping("/dataClasses")
    public String dataClasses() {
        return "adminPages/charts/data";
    }

    @GetMapping("/moreInfo")
    public String adminDashboard(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Arrays.asList(ROLE.values()));
        return "adminPages/forms/add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/fees")

    public void checkFeesAndSendReminders() {
        System.out.println("/////////////////////////////"+userRepository.findTeacherStudentCounts());
    }
}

