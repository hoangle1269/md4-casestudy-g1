package com.example.md4casestudy.service.fee;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.model.User;
import com.example.md4casestudy.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FeeService {
    @Autowired
    private FeeRepository feeRepository;

    public void save(Student student) {
        Date date = new Date();
        Fee fee = new Fee();
        fee.setStudent(student);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fee.setDueDate(date);
        fee.setAmount(11111111111.0);
        feeRepository.save(fee);
    }
}
