package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.ENUM.ROLE;
import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.Subject;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.model.dto.ClassAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentAverageGradeDTO;
import com.example.md4casestudy.model.dto.StudentDTO;
import com.example.md4casestudy.repository.GradeRepository;
import com.example.md4casestudy.repository.UserRepository;
import com.example.md4casestudy.model.dto.TeacherStudentCountDTO;
import com.example.md4casestudy.service.appUser.AppUserService;
import com.example.md4casestudy.service.classes.ClassService;
import com.example.md4casestudy.service.fee.FeeService;
import com.example.md4casestudy.service.student.StudentService;
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
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private FeeService feeService;
    boolean check = false;

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
        model.addAttribute("check", check);
        check = false;
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
        model.addAttribute("studentDTO", new StudentDTO());
        model.addAttribute("studentStatus", Arrays.asList(STUDENT_STATUS.values()));
        model.addAttribute("classes", classService.listClass());
        model.addAttribute("class", new Classes());
        model.addAttribute("listLecturer", userRepository.findByRole(ROLE.ROLE_LECTURER.getRoleName()));

        return "adminPages/forms/add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.save(user);
        check = true;
        return "redirect:/admin";
    }

    @PostMapping("/saveSubject")
    public String saveSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        check = true;
        return "redirect:/admin";
    }

    @PostMapping("/saveStudent")
    public String saveSubject(@ModelAttribute("student") StudentDTO studentDTO) {
        User user = userService.findByFullName(studentDTO.getUserName());
        Classes classes = classService.findById(studentDTO.getClassId());
        Student student = new Student();
        student.setUser(user);
        student.setClassName(classes);
        student.setStatus(studentDTO.getStatus());
        studentService.save(student);
        feeService.save(student);
        check = true;
        return "redirect:/admin";
    }
    @PostMapping("/saveClass")
    public String saveClass(@ModelAttribute("class") Classes classes) {
        classService.save(classes);
        check = true;
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

