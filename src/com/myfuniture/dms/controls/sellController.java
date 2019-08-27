/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfuniture.dms.controls;

import com.myfuniture.dms.model.sell;
import com.myfuniture.dms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aravinda
 */
public class sellController {
    
    
        static public boolean update(sell ss){
        try {
            String sql = "UPDATE debtors SET purchase_name=?, amount=?, bad_debt_date=? WHERE id=?";

            Connection con = DB.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
             
            ps.setString(1, ss.getName());
            ps.setDouble(2, ss.getAmount());
            java.sql.Date targetDate = new java.sql.Date(ss.getTargetDate().getTime());
            ps.setDate(3, targetDate);
            ps.setInt(4, ss.getId()); 
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    public static boolean save(sell ss){
        
        try{
            //1.creat sql statement
                String sql1 = "Insert into debtors(purchase_name,amount,bad_debt_date,purchase_date,status) VALUES(?,?,?,NOW(),0)";
            //2.get connection
               Connection con = DB.getConnection(); 
            //3.Creat a prepared statement
                PreparedStatement ps = con.prepareStatement(sql1);
            //4.Filled prepaired statment
               ps.setString(1, ss.getName());
               ps.setDouble(2, ss.getAmount());
               java.sql.Date targetDate = new java.sql.Date(ss.getTargetDate().getTime());
               ps.setDate(3, targetDate);

            
             //5.Execute statement       
                ps.executeUpdate();    
        
                return true;

        }catch(Exception e){
            e.printStackTrace();
            return false;
            
        }
    }
    
    
      
    
    
    
    
       public static List<sell> list(){
        
        try{
            
            
            List<sell> list = new ArrayList<sell>();
            
            //1.sql
            String sql ="select * from debtors";
            
            //2.db connection
            Connection con = DB.getConnection();
            
            //3. creat ps
            PreparedStatement ps = con.prepareStatement(sql);
            

            //5.execut sql
            ResultSet rs = ps.executeQuery();
            
            //6.creat target object and add to the list
            while(rs.next()){
                
                String name = rs.getString("purchase_name");
                Double amount = rs.getDouble("amount");
                Date baddebttdate = rs.getDate("bad_debt_date");
                Integer id = rs.getInt("id");
                Integer status = rs.getInt("status");
                
                
                sell sm = new sell();
                sm.setName(name);
                sm.setAmount(amount);
                sm.setTargetDate(baddebttdate);
                sm.setId(id);
                sm.setStatus(status);
                
                list.add(sm);
            }
            
            
            return list;
        }catch(Exception e){
            
            e.printStackTrace();
            return null;
            
        }
        
    }
       
       
       
    
    
    public static sell get(int id){
        try {
            sell s1 = new sell();
            String sql = "SELECT * FROM debtors WHERE id=?";
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, id); 
            ResultSet rs =  ps.executeQuery(); 
            if(rs.next()){
                Integer idnum = rs.getInt("id");
                String name = rs.getString("purchase_name");
                Double amount = rs.getDouble("amount"); 
                Date badDate = rs.getDate("bad_debt_date");
                Date purchaseDate = rs.getDate("purchase_date");
                Integer status = rs.getInt("status"); 
                
                s1.setId(idnum);
                s1.setName(name);
                s1.setAmount(amount);
                s1.setTargetDate(badDate);
                s1.setStartDate(purchaseDate);
                s1.setStatus(status); 
            }
            return s1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
  
    
    
    public static boolean delete(int id) {
        try { 
            String sql = "UPDATE debtors SET status=-1 WHERE id=?";
 
            Connection con = DB.getConnection(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1,id);   
            ps.executeUpdate();
             
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public static double getContributionTotal(int id){
        try {
            double ct = 0;
            String sql = "SELECT SUM(amount) AS ct FROM debtor_payments WHERE target_id=?";
            Connection con = DB.getConnection();
            PreparedStatement ps =con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ct = rs.getDouble("ct");
            }
            return ct;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
       
       
       
       
    
    
}
