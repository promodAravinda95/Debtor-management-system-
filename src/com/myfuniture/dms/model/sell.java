/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfuniture.dms.model;

import com.myfuniture.dms.controls.sellController;
import java.util.Date;

/**
 *
 * @author Aravinda
 */
public class sell {
    
    private int id;
    private String name;
    private double amount;
    private Date targetDate;
    private Date startDate;
    private int status;    


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount(double amount) {
        this.amount = amount;
    }


    public Date getTargetDate() {
        return targetDate;
    }


    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the status
     */
    public int isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
    
    
    
    
    
        @Override
    public String toString() {
        return getName()+" "+getAmount(); 
    }
        
        
    public double getPaymentTotal(){
        double PaymentTotal = sellController.getContributionTotal(getId());
        
        return PaymentTotal;
    }
    
    public double getBalance(){
        return getAmount() - getPaymentTotal();
    }

    
    
}
