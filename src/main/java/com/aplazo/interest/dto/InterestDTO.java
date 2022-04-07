package com.aplazo.interest.dto;

public class InterestDTO {
    private Long id;

    private Double amount;
    
    private Integer terms;

    private Double rate;

    public InterestDTO(){}

    public InterestDTO(Long id, Double amount, Integer terms, Double rate){
        this.id = id;
        this.amount = amount;
        this.terms = terms;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "InterestDTO [amount=" + amount + ", id=" + id + ", rate=" + rate + ", terms=" + terms + "]";
    }

    
}
