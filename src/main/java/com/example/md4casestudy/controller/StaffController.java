package com.example.md4casestudy.controller;


import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.Subject;
import com.example.md4casestudy.model.dto.*;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.StaffRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.service.appUser.AppUserService;
import com.example.md4casestudy.service.grade.GradeService;
import com.example.md4casestudy.service.student.StudentService;
import com.example.md4casestudy.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    GradeService gradeService;
    @Autowired
    private StudentService studentService;
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
        Student student = studentService.findById(id);
        model.addAttribute("studentInformation", student);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/edit/{idStudent}/{idGrade}")
    public String addStaff(@PathVariable("idStudent") Long idStudent,
                           @PathVariable("idGrade") Long idGrade,
                           Model model) {
        Grades grade = gradeService.findById(idGrade);
        ClassStudentGradeDTO classStudentGradeDTO = staffRepository.findClassStudentGradeDetailsByGradeId(idGrade);
        model.addAttribute("classStudentGradeDTO", classStudentGradeDTO);
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
        Student student = studentService.findById(idStudent);
        model.addAttribute("studentInformation", student);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/deleteGrade/{idStudent}/{idGrade}")
    public String deleteGrade(@PathVariable("idGrade") Long idGrade, @PathVariable("idStudent") Long idStudent, Model model) {
        gradeService.remove(idGrade);
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(idStudent);
        Student students = studentService.findById(idStudent);
        model.addAttribute("studentInformation", students);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/changeStatus/{isStudent}/{status}")
    public String changeStatus(@PathVariable("isStudent") Long studentId,
                               @PathVariable("status") String status,
                               Model model) {

        Student student = studentService.findById(studentId);
        if (student != null) {
            student.setStatus(status);
            studentService.save(student);
        }


        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(studentId);
        Student students = studentService.findById(studentId);
        model.addAttribute("studentInformation", students);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";
    }

    @GetMapping("/addGrade/{idStudent}")
    public String addGrade(@PathVariable("idStudent") Long idStudent, Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        Grades grades = new Grades();
        model.addAttribute("subjects", subjects);
        model.addAttribute("grade", grades);
        model.addAttribute("idStudent", idStudent);
        return "staffPages/forms/addGrade";
    }

    @PostMapping("/add/{idStudent}")
    public String addGradePost(@PathVariable("idStudent") Long idStudent, @ModelAttribute Grades grades, Model model) {
        Student student = studentService.findById(idStudent);
        grades.setStudent(student);
        grades.setAverageGrade((grades.getTheoryGrade() + grades.getPracticalGrade()) / 2);
        gradeService.save(grades);
        List<ClassStudentGradeDTO> classAverageGradeDTO = staffRepository.findClassStudentGradeDetailsByStudentId(idStudent);
        Student students = studentService.findById(idStudent);
        model.addAttribute("studentInformation", students);
        model.addAttribute("classAverageGradeDTO", classAverageGradeDTO);
        return "staffPages/index";

    }

    @GetMapping("/reports")
    public String staffReports() {
        return "staffPages/index";
    }
}
