package com.example.md4casestudy.service.implFee;

import com.example.md4casestudy.model.DTO.ScoreDTO;
import com.example.md4casestudy.model.Score;

import java.util.List;

public interface IScoreService {
    List<ScoreDTO> getScoresByStudentId(Long studentId);
}
