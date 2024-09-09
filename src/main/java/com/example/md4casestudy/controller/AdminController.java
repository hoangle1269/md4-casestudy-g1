package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.AppUser;
import com.example.md4casestudy.service.user.IUserService;
import com.example.md4casestudy.service.student.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final IUserService userService;
    private final IStudentService studentService;
    public AdminController(IUserService userService, IStudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }


//    @GetMapping
//    public ModelAndView index(@PageableDefault(value = 10) Pageable pageable) {
//        Page<AppUser> users = userService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("user/index");
//        modelAndView.addObject("users", users);
//        return modelAndView;
//    }

//    @GetMapping("/students")
//    public ModelAndView students(@PageableDefault(value = 10) Pageable pageable) {
//        Page<Student> students = studentService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("student/index");
//        modelAndView.addObject("students", students);
//        return modelAndView;
//    }

//    @GetMapping("/create")
//    public ModelAndView createUserForm() {
//        ModelAndView modelAndView = new ModelAndView("user/create");
//        modelAndView.addObject("Users", new AppUser());
//        return modelAndView;
//    }
//
//    @GetMapping("create/subject")

//    @GetMapping("class{id}/adverage-score")
//    public ModelAndView classAverageScore(Long id) {
//
//    }
}
