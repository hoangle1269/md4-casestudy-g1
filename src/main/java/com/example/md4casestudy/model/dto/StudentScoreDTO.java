package com.example.md4casestudy.model.dto;

import java.math.BigDecimal;

public interface StudentScoreDTO {
    Long getStudentId();
    String getFullName();
    String getEmail();
    String getClassName();
    BigDecimal getTheoryScore();
    BigDecimal getPracticalScore();
    String getStatus();
}
