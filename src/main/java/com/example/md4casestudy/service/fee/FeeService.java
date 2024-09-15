package com.example.md4casestudy.service.fee;

import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.Student;
import com.example.md4casestudy.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Calendar;

@Service
public class FeeService {
    @Autowired
    private FeeRepository feeRepository;

    public void save(Student student) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());

        Fee fee = new Fee();
        fee.setStudent(student);
        fee.setDueDate(date);
        fee.setAmount(111111.0);
        fee.setStatus("tuition debt");
        feeRepository.save(fee);
    }
}
