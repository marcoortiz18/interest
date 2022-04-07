package com.aplazo.interest.controller;

import java.util.List;

import com.aplazo.interest.dto.InterestDTO;
import com.aplazo.interest.dto.MonthlyPaymentDTO;
import com.aplazo.interest.service.IInterestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interest")
public class InterestController {
    
    @Autowired
    IInterestService interestService;

    @PostMapping("/new")
    public List<MonthlyPaymentDTO> save(@RequestBody InterestDTO interest){
        return interestService.post(interest);
    }
}
