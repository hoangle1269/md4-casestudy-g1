package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


//Chứa thông tin về các lớp học.
@Entity
@Data
@Table(name = "classes")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String className;

    public Classroom() {

    }

    public Classroom(Long id, @NonNull String className) {
        this.id = id;
        this.className = className;
    }
}
