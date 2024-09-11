package com.example.md4casestudy.model.DTO;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ScoreDTO {
    private Long scoreId;
    private Integer examPeriod;
    private Long studentId;
    private String subjectName;
    private BigDecimal theoryGrade;
    private BigDecimal practicalGrade;
}
