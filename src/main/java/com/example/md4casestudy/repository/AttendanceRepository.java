package com.example.md4casestudy.repository;

import com.example.md4casestudy.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByClasses_ClassId(Long classId);
}
