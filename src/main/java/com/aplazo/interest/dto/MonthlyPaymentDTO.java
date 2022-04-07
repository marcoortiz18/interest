package com.aplazo.interest.dto;

import java.util.Date;

public class MonthlyPaymentDTO {
    private Integer id;

    private Integer payment_number;

    private Double amount;
    
    private Date date;

    private InterestDTO interest;

    public MonthlyPaymentDTO(){}

    public MonthlyPaymentDTO(Integer payment_number, Double amount, Date date, InterestDTO interest){
        this.payment_number = payment_number;
        this.amount = amount;
        this.date = date;
        this.interest = interest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayment_number() {
        return payment_number;
    }

    public void setPayment_number(Integer payment_number) {
        this.payment_number = payment_number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public InterestDTO getInterest() {
        return interest;
    }

    public void setInterest(InterestDTO interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "MonthlyPaymentDTO [amount=" + amount + ", date=" + date + ", id=" + id + ", interest=" + interest
                + ", payment_number=" + payment_number + "]";
    }
}
