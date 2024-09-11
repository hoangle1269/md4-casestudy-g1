package com.example.md4casestudy.controller;

import com.example.md4casestudy.model.DTO.ScoreDTO;
import com.example.md4casestudy.service.implFee.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    private IScoreService scoreService;
    @GetMapping("/student/{studentId}/scores")
    public String getScoresByStudentId(@PathVariable("studentId") Long studentId, Model model) {
        List<ScoreDTO> scores = scoreService.getScoresByStudentId(studentId);
        model.addAttribute("scores", scores);
        return "score/scoreView";
}
}
