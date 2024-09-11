package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.ClassAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentAverageGradeDTO;
import com.example.md4casestudy.model.dto.TeacherStudentCountDTO;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.service.appUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        List<User> student = new ArrayList<User>();
        for (StudentAverageGradeDTO studentAverageGrade : studentAverageGradeDTO) {
            student.add(studentAverageGrade.getStudents());
        }
        model.addAttribute("student", student);
        return "staffPages/index";
    }

    @GetMapping("/reports")
    public String staffReports() {
        return "staff/reports";
    }
}
