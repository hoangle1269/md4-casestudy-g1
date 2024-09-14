package com.example.md4casestudy.service.attendance;

import com.example.md4casestudy.model.Attendance;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;

public interface IAttendanceService extends IGenerateService<Attendance> {

    void saveAttendance(Long classId, Long lecturerId, String content);

    List<Attendance> findByClassId(Long classId);
}