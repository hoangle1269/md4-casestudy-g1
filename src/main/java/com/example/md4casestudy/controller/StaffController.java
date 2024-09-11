package com.example.md4casestudy.controller;


import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.*;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.StaffRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.service.appUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    AppUserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GradeRepository gradesRepository;
    @Autowired
    private StaffRepository staffRepository;

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
        return "staffPages/index";
    }

    @GetMapping("/studentList/{id}")

    public String checkFeesAndSendReminders(Model model, @PathVariable long id) {
        List<StudentAverageGradeDTO> studentAverageGradeDTO = gradesRepository.findAverageGradesByClassId(id);
        List<StudentIdDTO> student = new ArrayList<StudentIdDTO>();
        for (StudentAverageGradeDTO studentAverageGrade : studentAverageGradeDTO) {
            student.add(new StudentIdDTO(studentAverageGrade.getStudents().getFullName(), studentAverageGrade.getStudents().getEmail(), studentAverageGrade.getStudent().getStudentId()));
        }
        model.addAttribute("student", student);
        return "staffPages/index";
    }

    @GetMapping("/grades/{id}")
    public String staffClasses(Model model, @PathVariable Long id) {
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(id);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/add")
    public String addStaff(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roles", Arrays.asList(ROLE.values()));
        return "staffPages/forms/addAndEdit";
    }

    @GetMapping("/reports")
    public String staffReports() {
        return "staffPages/index";
    }
}
