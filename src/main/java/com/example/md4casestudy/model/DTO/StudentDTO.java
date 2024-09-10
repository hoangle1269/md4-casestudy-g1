package com.example.md4casestudy.model.DTO;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Score;
import com.example.md4casestudy.model.StudentStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
@Data
public class StudentDTO {
private Long studentId;
private String fullName;
private String email;
private String phoneNumber;
private String address;
private LocalDate dateOfBrith;
private StudentStatus status;
private Class aClass;
private Set<Score> scores;
private Set<Fee> fees;
}
