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
        // Tìm lớp học dựa trên classId
        Classes classes = iClassRepos.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found with id: " + classId));

        // Tìm giảng viên dựa trên lecturerId
        Lecturer lecturer = ilecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + lecturerId));

        // Tạo đối tượng Attendance và thiết lập các thuộc tính
        Attendance attendance = new Attendance();
        attendance.setAClasses(classes);
        attendance.setLecturer(lecturer);
        attendance.setDate(LocalDate.now());
        attendance.setContent(content);

        // Lưu đối tượng Attendance vào cơ sở dữ liệu
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
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }
}
