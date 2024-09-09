package com.example.md4casestudy.service.attendance;


import com.example.md4casestudy.model.Attendance;
import com.example.md4casestudy.model.Classes;
import com.example.md4casestudy.model.Lecturer;
import com.example.md4casestudy.repository.AttendanceRepository;
import com.example.md4casestudy.repository.IClassRepos;
import com.example.md4casestudy.repository.ILecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements IAttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private IClassRepos iClassRepos;

    @Autowired
    private ILecturerRepository ilecturerRepository;


    @Override
    public void saveAttendance(Long classId, Long lecturerId, String content) {
        if (classId == null || lecturerId == null) {
            throw new IllegalArgumentException("classId or lecturerId must not be null");
        }

        Classes classes = iClassRepos.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + classId));

        Lecturer lecturer = ilecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + lecturerId));

        Attendance attendance = new Attendance();
        attendance.setAClasses(classes);
        attendance.setLecturer(lecturer);
        attendance.setDate(LocalDate.now());
        attendance.setContent(content);

        attendanceRepository.save(attendance);
    }

    @Override
    public Iterable<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public void save(Attendance attendance) {

    }

    @Override
    public Optional<Attendance> findById(Long id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public void remove(Long id) {

    }
}
