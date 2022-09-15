/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.onlinecabservice.service.model.Customer;


/**
 *
 * @author Sumaiya
 */
public class CustomerDB {
    //create an object of SingleObject
    private static CustomerDB instance = new CustomerDB();
   
    //make the constructor private so that this class cannot be instantiated
    private CustomerDB(){}
   
    //Get the only object available
    public static CustomerDB getInstance(){
       return instance;
    }
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    Customer customer = null;   
    
    //GET a customer by its id
    public Customer getCustomer(int id) {
        query = "call cabservicedatabase.getCustomer(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                customer = new Customer(resultSet.getInt("CustomerID"), resultSet.getString("CustomerNIC"), resultSet.getString("CustomerUsername"), resultSet.getString("CustomerPassword"), resultSet.getString("CustomerFirstName"), resultSet.getString("CustomerLastName"), resultSet.getString("CustomerEmail"), resultSet.getInt("CustomerPhoneNumber"), resultSet.getString("CustomerLoginStatus"), resultSet.getString("CustomerStatus"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }
    
    
    
    
}
