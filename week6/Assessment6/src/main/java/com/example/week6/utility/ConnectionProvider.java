package com.example.week6.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection connection;
 public static Connection connectionProvider(){
     try{
         String url="jdbc:mysql://localhost:3306/data";
         String username="root";
         String password="Rajat@23";
         connection = (Connection) DriverManager.getConnection(url,username,password);
     }
     catch (Exception e)
     {
         System.out.println(e.getMessage());
     }
        return connection;
 }
}
