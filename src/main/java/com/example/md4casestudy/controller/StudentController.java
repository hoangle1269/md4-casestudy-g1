package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.ClassStudentGradeDTO;
import com.example.md4casestudy.repository.StaffRepository;
import com.example.md4casestudy.service.appUser.AppUserService;
import com.example.md4casestudy.service.student.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public String staffClasses(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long idUser = user.getId();
        System.out.println("//////////////////////////////////////");
        System.out.println(idUser);
        Student students = studentService.getById(idUser);
        System.out.println("/////////////////////////////////////////");
        System.out.println(students);
        Long idStudent = students.getStudentId();
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(idStudent);
        Student student = studentService.findById(idStudent);
        model.addAttribute("studentInformation", student);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "index2";
    }

    @GetMapping("/enrollments")
    public String studentEnrollments() {
        return "student/enrollments";
    }
}
