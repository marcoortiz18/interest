package com.aplazo.interest;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aplazo.interest.model.Interest;
import com.aplazo.interest.repository.IInterestRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class InterestRepositoryTest {
    @Autowired
    private IInterestRepository repoInterest;
    
    @Test
    public void saveInterest(){
        Double amount = 1500.00; 
        Integer terms = 12; 
        Double rate = 25.0;
        Interest interest_25 = new Interest(amount, terms, rate);

        amount = 1500.00; 
        terms = 12; 
        rate = 25.0;
        Interest interest_50 = new Interest(amount, terms, rate);

        repoInterest.save(interest_25);
        repoInterest.save(interest_50);

        repoInterest.flush();

        assertEquals(2, repoInterest.findAll().size());
    }
}
