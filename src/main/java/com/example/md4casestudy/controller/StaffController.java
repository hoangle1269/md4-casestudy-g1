package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.service.ScoreService;
import com.example.md4casestudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StudentService studentService;
    @GetMapping
    public String home (){
        return "staff/home";
    }

    @GetMapping("/students")
    public String viewStudentList( Model model) {

//        List<Student> students = studentService.getAllStudentsByClass(classId);
        List<Student> students = studentService.getAllStudents();  // Using service method to fetch students from DB
        model.addAttribute("students", students);
        model.addAttribute("statuses", STUDENT_STATUS.values());
        return "staff/students";
    }


    @PostMapping("/students/update-status")
    public String updateStudentStatus(@RequestParam("studentId") Long studentId,
                                      @RequestParam("status") STUDENT_STATUS newStatus) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentService.updateStatus(studentId, newStatus);
        }
        return "redirect:/staff/students";
    }


}