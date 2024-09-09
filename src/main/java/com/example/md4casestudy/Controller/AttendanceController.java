package com.example.md4casestudy.Controller;

import com.example.md4casestudy.service.attendance.IAttendanceService;
import com.example.md4casestudy.service.classes.IClassService;
import com.example.md4casestudy.service.lecturer.ILecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.md4casestudy.model.Attendance;
import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.Lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @Autowired
    private IClassService classesService;

    @Autowired
    private ILecturerService lecturerService;

    @ModelAttribute("classes")
    public Iterable<Classes> classes() {
        return classesService.findAll();
    }

    @ModelAttribute("lecturers")
    public Iterable<Lecturer> lecturers() {
        return lecturerService.findAll();
    }

    @GetMapping
    public String getAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.findAll());
        return "/attendance/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "/attendance/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("attendance") Attendance attendance,
                         RedirectAttributes redirectAttributes) {
        if (attendance.getAClasses() == null || attendance.getAClasses().getClassId() == null ||
                attendance.getLecturer() == null || attendance.getLecturer().getLecturerId() == null) {
            redirectAttributes.addFlashAttribute("error", "Class or Lecturer information is missing.");
            return "redirect:/attendances/create";
        }

        attendanceService.saveAttendance(
                attendance.getAClasses().getClassId(),
                attendance.getLecturer().getLecturerId(),
                attendance.getContent()
        );
        redirectAttributes.addFlashAttribute("message", "Create new attendance successfully");
        return "redirect:/attendances";
    }

//    @GetMapping("{id}/view")
//    public ModelAndView viewAttendance(@PathVariable("id") Long id) {
//        Optional<Attendance> attendanceOptional = attendanceService.getAttendanceById(id);
//        if (!attendanceOptional.isPresent()) {
//            return new ModelAndView("/error_404");
//        }
//
//        ModelAndView modelAndView = new ModelAndView("/attendance/view");
//        modelAndView.addObject("attendance", attendanceOptional.get());
//        return modelAndView;
//    }
}
