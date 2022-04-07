package com.aplazo.interest.repository;


import com.aplazo.interest.model.MonthlyPayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonthlyPaymentRepository extends JpaRepository<MonthlyPayment, Long>{
    
}
