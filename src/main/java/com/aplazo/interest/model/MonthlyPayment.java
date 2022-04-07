package com.aplazo.interest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MonthlyPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer payment_number;

    @Column(nullable = false)
    private Double amount;
    
    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    @JoinColumn(name="interest_id")
    private Interest interest;

    public MonthlyPayment(){}

    public MonthlyPayment( Integer payment_number, Double amount, Date date, Interest interest){
        this.payment_number = payment_number;
        this.amount = amount;
        this.date = date;
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "MonthlyPayment [amount=" + amount + ", date=" + date + ", id=" + id 
                + ", payment_number=" + payment_number + "]";
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

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }
    
    
}
