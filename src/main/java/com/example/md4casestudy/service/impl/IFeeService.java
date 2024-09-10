package com.example.md4casestudy.service.impl;

import com.example.md4casestudy.model.DTO.FeeDTO;
import com.example.md4casestudy.model.Fee;

import java.util.List;

public interface IFeeService {
    FeeDTO getNextFee(Long studentId);
    List<Fee> getFeeHistory(Long studentId);
}
