package com.example.md4casestudy.service.impl;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.FeeStatus;
import com.example.md4casestudy.repository.IFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FeeService implements IFeeService{
  @Autowired
    IFeeRepository iFeeRepository;


    @Override
    public FeeDTO getNextFee(Long studentId) {
        List<Object[]> results = iFeeRepository.findNextFeeAndStatus(studentId);
        if (results.isEmpty()){
            return  null;
        }
        Object[] row = results.get(0);
        FeeDTO feeDTO = new FeeDTO();
        feeDTO.setFeeId(((Number) row[0]).longValue());
        feeDTO.setAmount((BigDecimal) row[1]);
        feeDTO.setStatus(FeeStatus.valueOf((String) row[2]));
        feeDTO.setDueDate((LocalDate) row[3]);

        return feeDTO;
    }

    @Override
    public List<Fee> getFeeHistory(Long studentId) {
        return List.of();
    }
}
