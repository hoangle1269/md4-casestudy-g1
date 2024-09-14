package com.example.md4casestudy.service.score;

import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;

public interface IScoreService extends IGenerateService<Score> {

    List<Score> getAllScores();

}
