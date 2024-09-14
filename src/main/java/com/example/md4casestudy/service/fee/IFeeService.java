package com.example.md4casestudy.service.fee;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.service.IGenerateService;

import java.util.List;
import java.util.Optional;


public interface IFeeService extends IGenerateService<Fee> {
    Optional<Fee> findByStudentId(Long studentId);
    List<Fee> findByStudent(Long studentId);

}