package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Classes;
import lombok.Data;

@Data
public class ClassAverageGradeDTO {
    private Classes className;
    private Double avgGrade;

    public ClassAverageGradeDTO(Classes className, Double avgGrade) {
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