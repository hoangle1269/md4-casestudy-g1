package com.example.md4casestudy.Controller;



import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.service.classes.IClassService;
import com.example.md4casestudy.service.student.IStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IClassService classService;

    @Autowired
    private IStudentService studentService;






   @GetMapping("/create")
   public String create(Model model) {
   model.addAttribute("student",new Student());
   return "/student/create";
   }


   @PostMapping("/save")
    public String create(@ModelAttribute("student") Student student,
                         RedirectAttributes redirectAttributes) {
        studentService.save(student);
        redirectAttributes.addFlashAttribute("message", "Create new student successfully");
        return "redirect:/students";
    }


    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/student/update");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("student") Student student,
                         RedirectAttributes redirect) {
        studentService.save(student);
        redirect.addFlashAttribute("message", "Update student successfully");
        return "redirect:/students";
    }
    @GetMapping("{id}/view")//hiển thị ds của
    public ModelAndView viewManufacturer(@PathVariable("id") Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ModelAndView("/error_404");
        }


        ModelAndView modelAndView = new ModelAndView("/student/view");
        //trung voi list cua car(Object)
        modelAndView.addObject("student", studentOptional.get());
        return modelAndView;
    }


    @GetMapping("/search")
    public ModelAndView searchStudentsByClass(@RequestParam(value = "className", required = false) String className) {
        Iterable<Student> students;
        if (className != null && !className.isEmpty()) {
            students = studentService.findAllByClassName(className);
        } else {
            students = studentService.findAll(); // Trả về danh sách tất cả học viên nếu không có className
        }

        ModelAndView modelAndView = new ModelAndView("student/list"); // Tên của Thymeleaf template để hiển thị danh sách học viên
        modelAndView.addObject("students", students);
        modelAndView.addObject("classes", classService.findAll()); // Đưa danh sách lớp học để dùng trong form tìm kiếm
        return modelAndView;
    }
}