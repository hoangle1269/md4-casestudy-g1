package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.Subject;
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
