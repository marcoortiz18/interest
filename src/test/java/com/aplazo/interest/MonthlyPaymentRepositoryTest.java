package com.aplazo.interest;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import com.aplazo.interest.model.Interest;
import com.aplazo.interest.model.MonthlyPayment;
import com.aplazo.interest.repository.IInterestRepository;
import com.aplazo.interest.repository.IMonthlyPaymentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MonthlyPaymentRepositoryTest {
    @Autowired
    private IInterestRepository repoInterest;

    @Autowired
    private IMonthlyPaymentRepository repoMonthly;
    
    @Test
    public void saveMonthly(){
        Double amount = 1500.00; 
        Integer terms = 12; 
        Double rate = 25.0;
        Interest interest_25 = new Interest(amount, terms, rate);
        
        repoInterest.save(interest_25);
        repoInterest.flush();

        Integer payment_number = 1; 
        Double amountPayment = 124.00;
        Date date = new Date();

        MonthlyPayment payment_25 = new MonthlyPayment(payment_number, amountPayment, date, interest_25);

        repoMonthly.save(payment_25);
        repoMonthly.flush();

        assertEquals(1, repoMonthly.findAll().size());
    }
}
