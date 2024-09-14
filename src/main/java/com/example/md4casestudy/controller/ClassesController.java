package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Lecturer;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.service.classes.ClassService;
import com.example.md4casestudy.service.lecturer.ILecturerService;
import com.example.md4casestudy.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassService classService;

    @Autowired
    private ILecturerService lecturerService;

    @Autowired
    private StudentService studentService;

    @ModelAttribute("lecturers")
    public Iterable<Lecturer> lecturers() {
        return lecturerService.findAll();
    }

    @GetMapping
    public String getAllClass(Model model) {
        model.addAttribute("classes", classService.findAll());
        return "lecturer/class/list"; // Tên file HTML bạn sẽ tạo để hiển thị danh sách học viên
    }
    @GetMapping("/students")
    public String getStudentsByClassId(@RequestParam("classId") Long classId,
                                       @RequestParam(value = "status", required = false) STUDENT_STATUS status,
                                       Model model) {
        Optional<Classes> optionalClasses = classService.findById(classId);

        if (optionalClasses.isPresent()) {
            Classes classes = optionalClasses.get();
            List<Student> students;

            if (status != null) {
                students = studentService.findStudentsByClassIdAndStatus(classId, status);
            } else {
                students = studentService.findByClassId(classId);
            }

            model.addAttribute("students", students);
            model.addAttribute("totalStudents", students.size());
            model.addAttribute("class", classes);
            return "lecturer/student/students";
        } else {
            // Xử lý khi lớp học không tồn tại (ví dụ: trả về trang lỗi hoặc trang không tìm thấy)
            return "error";
        }

    }
}