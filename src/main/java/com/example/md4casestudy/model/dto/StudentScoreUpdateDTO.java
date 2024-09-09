package com.example.md4casestudy.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class StudentScoreUpdateDTO {

    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;

    @NotNull(message = "Theory score is required")
    @Positive(message = "Theory score must be a positive number")
    private BigDecimal theoryScore;

    @NotNull(message = "Practical score is required")
    @Positive(message = "Practical score must be a positive number")
    private BigDecimal practicalScore;

}

