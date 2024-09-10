package com.example.md4casestudy.service.implFee;


import com.example.md4casestudy.model.DTO.ScoreDTO;
import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.repository.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService implements IScoreService{
    @Autowired
    private IScoreRepository scoreRepository;

    @Override
    public List<ScoreDTO> getScoresByStudentId(Long studentId) {
       List<Object[]> result = scoreRepository.findStudentScores(studentId);
        return result.stream().map(row -> {
            ScoreDTO dto = new ScoreDTO();
            dto.setExamPeriod(((Number) row[0]).intValue());
            dto.setTheoryGrade((BigDecimal) row[1]);
            dto.setPracticalGrade((BigDecimal) row[2]);
            dto.setSubjectName((String) row[3]);
            return dto;
        }).collect(Collectors.toList());
    }
}
