/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfuniture.dms.model;

import com.myfuniture.dms.view.sellManage;
import java.util.Date;

/**
 *
 * @author Aravinda
 */
public class payment {
    
    
    private int id;
    private double amount;
    private Date date;
    private boolean status;
    private sell sell;
    private String name;
    

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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the sell
     */
    public sell getSell() {
        return sell;
    }

    /**
     * @param sell the sell to set
     */
    public void setSell(sell sell) {
        this.sell = sell;
    }
    


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    
    
}
