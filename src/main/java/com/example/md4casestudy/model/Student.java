package com.example.md4casestudy.model;

import com.example.md4casestudy.model.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//Chứa thông tin về học viên.
@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private AppUser studentUser;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classroom classroom;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Fee fee;

    public Student() {
    }

    public Student(Long id, AppUser studentUser, StudentStatus status, Classroom classroom, Subject subject, Fee fee) {
        this.id = id;
        this.studentUser = studentUser;
        this.status = status;
        this.classroom = classroom;
        this.subject = subject;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(AppUser studentUser) {
        this.studentUser = studentUser;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }
}
