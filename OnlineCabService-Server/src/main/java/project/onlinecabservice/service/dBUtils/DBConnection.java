/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.*;

/**
 *
 * @author Sumaiya
 */
public class DBConnection {
    
    //create an object of SingleObject
   private static DBConnection instance = new DBConnection();
   
   //make the constructor private so that this class cannot be instantiated
   private DBConnection(){}
   
   //Get the only object available
   public static DBConnection getInstance(){
      return instance;
   }
    
    //Databse Connection Variables
    static final String DATABASENAME = "cabservicedatabase";
    static final String URL = "jdbc:mysql://localhost:3306/" + DATABASENAME + "?autoReconnect=true&useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "Root@123";
    
    public Statement dBConnectionInit() {
        Statement statement = null;
        try{
            // Open a connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to Database");
            statement = connection.createStatement();
   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return statement;   
    }
}
