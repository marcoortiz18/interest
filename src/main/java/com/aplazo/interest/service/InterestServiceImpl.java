package com.aplazo.interest.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aplazo.interest.dto.InterestDTO;
import com.aplazo.interest.dto.MonthlyPaymentDTO;
import com.aplazo.interest.model.Interest;
import com.aplazo.interest.model.MonthlyPayment;
import com.aplazo.interest.repository.IInterestRepository;
import com.aplazo.interest.repository.IMonthlyPaymentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl implements IInterestService{

    @Autowired
    private IInterestRepository interestRepo;
    
    @Autowired
    private IMonthlyPaymentRepository monthlyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MonthlyPaymentDTO> post(InterestDTO interest) {
        Interest interestEntity = modelMapper.map(interest, Interest.class);

        Double totalAmount = getAmountWithPercentage(interest);
        Double monthlyPayment = (double) Math.round(totalAmount / interest.getTerms());

        interestEntity = interestRepo.save(interestEntity);
        List<MonthlyPaymentDTO> paymentsDTO = getListMonthlyAmountDTO(interestEntity, monthlyPayment);
        
        return paymentsDTO;
    }
    
    private Double getAmountWithPercentage(InterestDTO interest){
        Double percentage = 0.0;

        percentage = interest.getAmount() + ((interest.getAmount() * interest.getRate()) / 100);

        return percentage;
    }

    private List<MonthlyPaymentDTO> getListMonthlyAmountDTO(Interest interest, Double monthlyPayment){
        List<MonthlyPaymentDTO> paymentsDTO = new ArrayList<>();
        MonthlyPaymentDTO paymentDTO = null;
        ModelMapper modelMapper = new ModelMapper();
        ZoneId defaultZoneId = ZoneId.systemDefault();

        for (int month_payment = 1; month_payment <= interest.getTerms(); month_payment++) {
            LocalDate today = LocalDate.now();
            
            LocalDate next_payment_date = today.plusMonths(month_payment);
            
            Date date = Date.from(next_payment_date.atStartOfDay(defaultZoneId).toInstant());
            
            MonthlyPayment paymentEntity = new MonthlyPayment(month_payment, monthlyPayment, date, interest);

            paymentEntity = monthlyRepo.save(paymentEntity);
            
            paymentDTO = modelMapper.map(paymentEntity, MonthlyPaymentDTO.class);
            
            paymentsDTO.add(paymentDTO);
        }

        return paymentsDTO;
    }
}
