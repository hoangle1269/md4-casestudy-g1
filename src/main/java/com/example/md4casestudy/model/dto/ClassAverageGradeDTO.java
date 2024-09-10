package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Class;
import lombok.Data;

@Data
public class ClassAverageGradeDTO {
    private Class className;
    private Double avgGrade;

    public ClassAverageGradeDTO(Class className, Double avgGrade) {
        this.className = className;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "ClassAverageGradeDTO{" +
                "classId=" + className +
                ", avgGrade=" + avgGrade +
                '}';
    }

}
