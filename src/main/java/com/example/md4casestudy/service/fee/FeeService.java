package com.example.md4casestudy.service.fee;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Grades;
import com.example.md4casestudy.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeService implements IFeeService {
    @Autowired
    private FeeRepository feeRepository;

    @Override
    public Iterable<Fee> findAll() {
        return feeRepository.findAll();
    }

    @Override
    public Fee findById(Long id){
        return feeRepository.findById(id).get();
    }

    @Override
    public void save(Fee fee) {
        feeRepository.save(fee);
    }

    @Override
    public void remove(Long id) {
        feeRepository.deleteById(id);
    }

    @Override
    public Grades updateGrades(Grades grade) {
        return null;
    }

    @Override
    public Optional<Fee> findByStudentId(Long studentId) {
        return feeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Fee> findByStudent(Long studentId) {
        return feeRepository.findByStudent(studentId);
    }
}
