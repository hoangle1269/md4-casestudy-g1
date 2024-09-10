package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.ENUM.STUDENT_STATUS;
import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.service.ScoreService;
import com.example.md4casestudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StudentService studentService;



    @PostMapping("/updateScore")
    public String updateScore(@RequestParam Long studentId, @RequestParam Long subjectId,
                              @RequestParam BigDecimal theoryScore, @RequestParam BigDecimal practicalScore) {
        scoreService.updateScore(studentId, subjectId, theoryScore, practicalScore);
        return "redirect:/staff/view-scores";
    }

    @GetMapping("/averageScore")
    public String getAverageScore(@RequestParam Long studentId, Model model) {
        BigDecimal average = scoreService.calculateAverage(studentId);
        model.addAttribute("average", average);
        return "/staff/average-score";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long studentId, @RequestParam STUDENT_STATUS status) {
        studentService.updateStatus(studentId, status);
        return "redirect:/staff/update-status";
    }

    @GetMapping("/viewScores")
    public String viewScores(Model model) {
        List<Score> scores = scoreService.getAllScores();
        model.addAttribute("scores", scores);
        return "/staff/view-scores";
    }



}