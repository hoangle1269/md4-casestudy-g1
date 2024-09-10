package com.example.md4casestudy.service.impl;

import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.model.Student;

import java.util.List;

public interface IScoreService {
    List<Score> getScoresByStudentId(Long studentId);
}
