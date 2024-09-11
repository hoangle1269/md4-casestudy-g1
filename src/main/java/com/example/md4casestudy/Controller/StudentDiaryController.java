package com.example.md4casestudy.Controller;

import com.example.md4casestudy.model.Lecturer;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.StudentDiary;
import com.example.md4casestudy.service.lecturer.ILecturerService;
import com.example.md4casestudy.service.student.IStudentService;
import com.example.md4casestudy.service.studentDiary.IStudentDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student-diaries")
public class StudentDiaryController {

    @Autowired
    private IStudentDiaryService studentDiaryService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ILecturerService lecturerService;
    // Các phương thức khác...

    @GetMapping("/list/{studentId}")
    public String listDiaries(@PathVariable Long studentId, Model model) {
        List<StudentDiary> diaries = studentDiaryService.findAllByStudentId(studentId);

        model.addAttribute("studentDiaries", diaries);
        model.addAttribute("studentId", studentId);
        return "/studentDiary/list";
    }

    // Hiển thị form tạo nhật ký
    @GetMapping("/create/{studentId}")
    public String createDiaryForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.findById(studentId).orElse(null);
        if (student == null) {
            return "redirect:/students";
        }

        Iterable<Lecturer> lecturers = lecturerService.findAll(); // Lấy danh sách giảng viên
        model.addAttribute("student", student);
        model.addAttribute("diary", new StudentDiary());
        model.addAttribute("lecturers", lecturers);

        return "/studentDiary/create";
    }

    // Xử lý lưu nhật ký
    @PostMapping("/save")
    public String saveDiary(@ModelAttribute("diary") StudentDiary diary,
                            @RequestParam("studentId") Long studentId,
                            @RequestParam("lecturerId") Long lecturerId,
                            RedirectAttributes redirectAttributes) {

        Student student = studentService.findById(studentId).orElse(null);
        Lecturer lecturer = lecturerService.findById(lecturerId).orElse(null);

        if (student == null || lecturer == null) {
            redirectAttributes.addFlashAttribute("error", "Student or Lecturer not found.");
            return "redirect:/student-diaries/create/" + studentId;
        }

        diary.setStudent(student);
        diary.setLecturer(lecturer);
        diary.setDate(LocalDate.now()); // Tự động đặt ngày hiện tại

        studentDiaryService.save(diary);

        redirectAttributes.addFlashAttribute("message", "Diary entry created successfully.");
        return "redirect:/student-diaries/list/" + studentId;
    }
}

