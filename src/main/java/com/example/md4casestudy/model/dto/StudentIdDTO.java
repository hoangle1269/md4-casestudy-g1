package com.example.md4casestudy.model.dto;

import com.example.md4casestudy.model.Student;

public class StudentIdDTO {
    private Student nameStudent;
    private String gmail;
    private Long idStudent;

    public StudentIdDTO() {
    }

    public StudentIdDTO(Student nameStudent, String gmail, Long idStudent) {
        this.nameStudent = nameStudent;
        this.gmail = gmail;
        this.idStudent = idStudent;
    }

    public Student getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(Student nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }
}
