package Main;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Human
 */
public class DBConnection {
    public static Connection mycon(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/transactionrecords","root","");
            
            return c;
        } catch (Exception e) {
            e.printStackTrace(); 
        }  
        return null;
    }
    
}
