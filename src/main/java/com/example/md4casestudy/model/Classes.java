package com.example.md4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


//Chứa thông tin về các lớp học.
@Entity
@Data
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;


    @Column(name = "class_name", nullable = false)
    private String className;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @OneToMany(mappedBy = "classes")
    private Set<Student> students; // Thêm liên kết đến học viên

}
