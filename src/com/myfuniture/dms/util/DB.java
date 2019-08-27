/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfuniture.dms.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aravinda
 */
public class DB {
    
    public static Connection getConnection() throws Exception{
        
        String url = "jdbc:mysql://localhost:3306/dbdms";
        String userName = "root";
        String password ="root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,userName,password);
        
        
        return con;
    }
    
}
