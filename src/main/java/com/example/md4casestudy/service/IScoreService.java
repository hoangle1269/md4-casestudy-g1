package com.example.md4casestudy.service;

import com.example.md4casestudy.model.Score;

import java.util.List;

public interface IScoreService extends IGenerateService<Score>{

    List<Score> getAllScores();

}
