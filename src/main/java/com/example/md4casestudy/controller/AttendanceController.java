package com.example.md4casestudy.controller;

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

import java.time.LocalDate;
import java.util.List;
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
    public String getAttendancesByClass(@RequestParam("classId") Long classId, Model model) {
        Optional<Classes> optionalClass = classesService.findById(classId);
        if (!optionalClass.isPresent()) {
            return "redirect:/error";
        }

        List<Attendance> attendances = attendanceService.findByClassId(classId);
        model.addAttribute("attendances", attendances);
        model.addAttribute("classId", classId);
        return "/lecturer/attendance/list";
    }

    // Controller method to display the form for creating attendance
    @GetMapping("/create")
    public String create(@RequestParam("classId") Long classId, Model model) {
        // Validate classId
        if (classId == null) {
            return "redirect:/error"; // Redirect to an error page or handle as needed
        }

        // Fetch class and check its existence
        Optional<Classes> optionalClass = classesService.findById(classId);
        if (!optionalClass.isPresent()) {
            return "redirect:/attendances"; // Redirect to attendances list if class not found
        }

        // Create a new Attendance object
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("classId", classId);
        model.addAttribute("classes", classesService.findAll()); // Optional, if needed
        model.addAttribute("lecturers", lecturerService.findAll()); // Fetch and add lecturers

        return "/lecturer/attendance/create"; // Ensure this matches the view template location
    }


    @PostMapping("/save")
    public String createSave(@ModelAttribute("attendance") Attendance attendance,
                             @RequestParam("lecturerId") Long lecturerId,
                             @RequestParam("classId") Long classId,
                             RedirectAttributes redirectAttributes) {

        Lecturer lecturer = lecturerService.findById(lecturerId).orElse(null);
        if (lecturer == null) {
            redirectAttributes.addFlashAttribute("error", "Lecturer not found.");
            return "redirect:/attendances/create?classId=" + classId;
        }
        attendance.setLecturer(lecturer);

        Classes classes = classesService.findById(classId).orElse(null);
        if (classes == null) {
            redirectAttributes.addFlashAttribute("error", "Class not found.");
            return "redirect:/attendances/create?classId=" + classId;
        }
        attendance.setClasses(classes);

        try {
            attendanceService.saveAttendance(
                    attendance.getClasses().getClassId(),
                    attendance.getLecturer().getLecturerId(),
                    attendance.getContent()
            );
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to create attendance.");
            return "redirect:/attendances/create?classId=" + classId;
        }

        redirectAttributes.addFlashAttribute("message", "Create new attendance successfully");
        return "redirect:/attendances?classId=" + classId;
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