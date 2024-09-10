package com.example.md4casestudy.service.implFee;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.model.Fee;

import java.util.List;

public interface IFeeService {
    List<FeeDTO> getAllFeeStatus(Long studentId);
}
