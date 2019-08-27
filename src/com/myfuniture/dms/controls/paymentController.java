/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfuniture.dms.controls;

import com.myfuniture.dms.model.payment;
import com.myfuniture.dms.model.sell;
import com.myfuniture.dms.util.DB;
import com.myfuniture.dms.view.payamentManage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aravinda
 */
public class paymentController {
    

    public static boolean save(payment pm){
        try {
            
            //3.Create SQL Statement
            String sql = "INSERT INTO debtor_payments"+
                            " (amount, date, target_id, status) "+
                            " VALUES (?,?,?,1)";

            //4. Create a database Connection
           Connection con = DB.getConnection();
            
            //5. Create a Prepared Statement
            PreparedStatement ps = con.prepareStatement(sql);
            
            //6. Fill Prepared Statement
            ps.setDouble(1, pm.getAmount()); 
            java.sql.Date date = new java.sql.Date(pm.getDate().getTime());
            ps.setDate(2, date);
            ps.setInt(3, pm.getSell().getId());
            
            //7. Execute Statement
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<payment> list(){
        try {
            List<payment> list = new ArrayList<payment>();
            //1. SQL
            String sql = "SELECT * FROM debtor_payments";
            //2. DB Connection
            Connection con = DB.getConnection();
            
            //3. Create PS
            PreparedStatement ps = con.prepareStatement(sql);
            //4. Set PS Parameter
            //5.Execute SQL
            ResultSet rs =  ps.executeQuery();
            //6. Create Target Objects and add to the List
            while(rs.next()){ 
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                Date date = rs.getDate("date");
                boolean status = rs.getBoolean("status");
                int sellId = rs.getInt("target_id");
                
                payment pm = new payment(); 
                pm.setId(id);
                pm.setAmount(amount);
                pm.setDate(date);
                pm.setStatus(status);
                sell s1 = sellController.get(sellId);
                pm.setSell(s1);
                
                
                list.add(pm);
            }
             
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
