package com.example.md4casestudy.model.dto;

public class StudentIdDTO {
    private String nameStudent;
    private String gmail;
    private Long idStudent;

    public StudentIdDTO() {
    }

    public StudentIdDTO(String nameStudent, String gmail, Long idStudent) {
        this.nameStudent = nameStudent;
        this.gmail = gmail;
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
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
