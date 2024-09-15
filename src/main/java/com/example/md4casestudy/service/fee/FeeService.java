package com.example.md4casestudy.service.fee;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Optional<Fee> findById(Long id) {
        return feeRepository.findById(id);
    }

    @Override
    public void save(Fee fee) {
        feeRepository.save(fee);
    }

    public void save(Student student) {
        Date date = new Date();
        Fee fee = new Fee();
        fee.setStudent(student);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fee.setDueDate(date);
        fee.setAmount(BigDecimal.valueOf(11111111111.0));
        feeRepository.save(fee);
    }

    @Override
    public void remove(Long feeId) {
        feeRepository.deleteById(feeId);
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