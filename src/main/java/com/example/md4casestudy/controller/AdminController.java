package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.Subject;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.ClassAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentAverageGradeDTO;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.model.dto.TeacherStudentCountDTO;
import com.example.md4casestudy.service.appUser.AppUserService;
import com.example.md4casestudy.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AppUserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GradeRepository gradesRepository;
    @Autowired
    private SubjectService subjectService;
    @GetMapping
    public String homePage(Model model) {
        List<TeacherStudentCountDTO> teacherStudentCountDTO = userRepository.findTeacherStudentCounts();
        List<TeacherStudentCountDTO> teacherStudentCount = new ArrayList<TeacherStudentCountDTO>();
        for (TeacherStudentCountDTO teacherStudentCountDTO1 : teacherStudentCountDTO) {
            if (teacherStudentCountDTO1.getClassName() != null) {
                teacherStudentCount.add(teacherStudentCountDTO1);
            }
        }
        model.addAttribute("teacherStudentCountDTO", teacherStudentCount);
        model.addAttribute("teacher", teacherStudentCountDTO);
        return "adminPages/index";
    }

    @GetMapping("/dataClasses")
    public String dataClasses(Model model) {
        List<ClassAverageGradeDTO> classAverageGradeDTO = gradesRepository.findAverageGradesByClass();
        List<String> classNames = new ArrayList<String>();
        List<Double> averageGrades = new ArrayList<Double>();
        List<Classes> classes = new ArrayList<Classes>();
        for (ClassAverageGradeDTO averageGradeDTO : classAverageGradeDTO) {
            classNames.add(averageGradeDTO.getClassName().getClassName());
            averageGrades.add(averageGradeDTO.getAvgGrade());
            classes.add(averageGradeDTO.getClassName());
        }


        model.addAttribute("classNames", classNames);
        model.addAttribute("averageGrades", averageGrades);
        model.addAttribute("classes", classes);

        return "adminPages/charts/data";
    }

    @GetMapping("/moreInfo")
    public String adminDashboard(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", Arrays.asList(ROLE.values()));
        model.addAttribute("subject", new Subject());
        return "adminPages/forms/add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/admin";
    }
    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/admin";
    }
    @GetMapping("/averageGrade/{id}")

    public String checkFeesAndSendReminders(Model model, @PathVariable long id) {
        List<ClassAverageGradeDTO> classAverageGradeDTO = gradesRepository.findAverageGradesByClass();
        List<StudentAverageGradeDTO> studentAverageGradeDTO = gradesRepository.findAverageGradesByClassId(id);
        List<String> studentNames = new ArrayList<String>();
        List<Double> averageGrades = new ArrayList<Double>();
        List<Classes> classes = new ArrayList<Classes>();
        for (ClassAverageGradeDTO averageGradeDTO : classAverageGradeDTO) {
            classes.add(averageGradeDTO.getClassName());
        }
        for (StudentAverageGradeDTO studentAverageGrade : studentAverageGradeDTO) {
            studentNames.add(studentAverageGrade.getStudents().getFullName());
            averageGrades.add(studentAverageGrade.getAverageGrade());
        }


        model.addAttribute("studentNames", studentNames);
        model.addAttribute("averageGrades", averageGrades);
        model.addAttribute("classes", classes);
        return "adminPages/charts/dataClass";
    }

}

