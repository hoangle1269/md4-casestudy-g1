package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.Subject;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ScoreDTO {
    private Long scoreId;
    private Student student;
    private Subject subject;
    private BigDecimal theoryGrade;
    private BigDecimal practicalGrade;

}
