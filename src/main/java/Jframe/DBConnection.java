/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lahiru
 */
public class DBConnection {
    
    static Connection  con= null;
    
    public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/libarary_management_system","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return con;
    }

   
  
}   
    
    
