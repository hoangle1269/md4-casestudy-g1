package com.example.md4casestudy.service.implFee;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.model.Fee;
import com.example.md4casestudy.model.FeeStatus;
import com.example.md4casestudy.repository.IFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeService implements IFeeService{
  @Autowired
    IFeeRepository iFeeRepository;


    @Override
    public List<FeeDTO> getAllFeeStatus(Long studentId) {
            List<Object[]> results = iFeeRepository.findAllFeeStatus(studentId);
            return results.stream().map(row -> {
                FeeDTO dto = new FeeDTO();
                dto.setFeeId(((Number) row[0]).longValue());
                dto.setAmount((BigDecimal) row[1]);
                dto.setStatus((FeeStatus)row[2]);
                dto.setDueDate((LocalDate) row[3]);
                return dto;
            }).collect(Collectors.toList());
        }
    }
