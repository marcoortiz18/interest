package com.aplazo.interest.repository;

import com.aplazo.interest.model.Interest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInterestRepository extends JpaRepository<Interest, Long>{
    
    
}
