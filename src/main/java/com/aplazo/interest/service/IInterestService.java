package com.aplazo.interest.service;

import java.util.List;

import com.aplazo.interest.dto.InterestDTO;
import com.aplazo.interest.dto.MonthlyPaymentDTO;

public interface IInterestService {
    public List<MonthlyPaymentDTO> post(InterestDTO interest);
}
