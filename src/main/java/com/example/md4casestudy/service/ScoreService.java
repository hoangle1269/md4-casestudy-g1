package com.example.md4casestudy.service;

import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService  implements IScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> findByStudent_StudentId(Long studentId) {
        return scoreRepository.findByStudent_StudentId(studentId);
    }


    public void updateScore(Long studentId, Long subjectId, BigDecimal theoryScore, BigDecimal practicalScore) {
        Score score = scoreRepository.findByStudent_StudentIdAndSubject_SubjectId(studentId, subjectId)
                .orElseThrow(() -> new RuntimeException("Score record not found"));
        score.setTheoryScore(theoryScore);
        score.setPracticalScore(practicalScore);
        scoreRepository.save(score);
    }


    public BigDecimal calculateAverage(Long studentId) {
        List<Score> scores = scoreRepository.findByStudent_StudentId(studentId);
        BigDecimal totalTheoryScore = BigDecimal.ZERO;
        BigDecimal totalPracticalScore = BigDecimal.ZERO;
        int count = scores.size();

        for (Score score : scores) {
            totalTheoryScore = totalTheoryScore.add(score.getTheoryScore());
            totalPracticalScore = totalPracticalScore.add(score.getPracticalScore());
        }

        BigDecimal averageTheoryScore = totalTheoryScore.divide(BigDecimal.valueOf(count), RoundingMode.HALF_UP);
        BigDecimal averagePracticalScore = totalPracticalScore.divide(BigDecimal.valueOf(count), RoundingMode.HALF_UP);
        // Combine averages if needed
        return averageTheoryScore.add(averagePracticalScore).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
    }

    @Override
    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Iterable<Score> findAll() {
        return null;
    }

    @Override
    public Optional<Score> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Score score) {

    }

    @Override
    public void remove(Long id) {

    }
}
