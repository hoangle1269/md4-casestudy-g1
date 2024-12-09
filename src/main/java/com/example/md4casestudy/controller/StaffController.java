package com.example.md4casestudy.controller;


import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.*;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.StaffRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.service.appUser.AppUserService;
import com.example.md4casestudy.service.gradeService.GradeService;
import com.example.md4casestudy.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    GradeService gradeService;
    @Autowired
    private StudentService studentService;

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
        List<StudentIdDTO> student = studentService.listStudent(id);
        model.addAttribute("student", student);
        return "staffPages/index";
    }

    @GetMapping("/grades/{id}")
    public String staffClasses(Model model, @PathVariable Long id) {
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(id);
        Optional<Student> student = studentService.findById(id);
        model.addAttribute("studentss", student.get());
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/add/{idStudent}/{idGrade}")
    public String addStaff(@PathVariable("idStudent") Long idStudent,
                           @PathVariable("idGrade") Long idGrade,
                           Model model) {
//        Grades grades = new Grades();
        Grades grade = gradeService.findById(idGrade);
        ClassStudentGradeDTO classStudentGradeDTO = staffRepository.findClassStudentGradeDetailsByGradeId(idGrade);
        model.addAttribute("classStudentGradeDTO", classStudentGradeDTO);
//        model.addAttribute("grades", grades);
        model.addAttribute("grade", grade);

        return "staffPages/forms/addAndEdit";
    }

    @PostMapping("/update/{idGrade}/{idStudent}")
    public String updateGrade(@PathVariable("idGrade") Long idGrade, @PathVariable("idStudent") Long idStudent, @ModelAttribute Grades grade, Model model) {
        Grades grades = gradeService.findById(idGrade);
        if (grades != null) {
            grades.setTheoryGrade(grade.getTheoryGrade());
            grades.setPracticalGrade(grade.getPracticalGrade());
            grades.setAverageGrade((grade.getTheoryGrade() + grade.getPracticalGrade()) / 2);
            gradeService.updateGrades(grades);
        }
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(idStudent);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/deleteGrade/{idStudent}/{idGrade}")
    public String deleteGrade(@PathVariable("idGrade") Long idGrade, @PathVariable("idStudent") Long idStudent, Model model) {
        gradeService.remove(idGrade);
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(idStudent);
        Optional<Student> student = studentService.findById(idStudent);
        model.addAttribute("studentss", student.get());
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/reports")
    public String staffReports() {
        return "staffPages/index";
    }
}
