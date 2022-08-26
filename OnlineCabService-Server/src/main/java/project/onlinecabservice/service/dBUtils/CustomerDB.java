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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
            
    //GET a customer by its id
    public Customer getCustomer(int id) {
        Customer customer = null;
        query = "SELECT * FROM customer WHERE id='" + id + "'";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                customer = new Customer(Integer.parseInt(resultSet.getString("CustomerID")), resultSet.getString("CustomerNIC"), resultSet.getString("CustomerUsername"), resultSet.getString("CustomerPassword"), resultSet.getString("CustomerFirstName"), resultSet.getString("CustomerLastName"), resultSet.getString("CustomerEmail"), Integer.parseInt(resultSet.getString("CustomerPhoneNumber")), resultSet.getString("CustomerLoginStatus"), resultSet.getString("CustomerStatus"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }
    
    
    //GET all customers
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        query = "SELECT * FROM customer";
        try {
            dBInit =  DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                Customer customer = new Customer(Integer.parseInt(resultSet.getString("CustomerID")), resultSet.getString("CustomerNIC"), resultSet.getString("CustomerUsername"), resultSet.getString("CustomerPassword"), resultSet.getString("CustomerFirstName"), resultSet.getString("CustomerLastName"), resultSet.getString("CustomerEmail"), Integer.parseInt(resultSet.getString("CustomerPhoneNumber")), resultSet.getString("CustomerLoginStatus"), resultSet.getString("CustomerStatus"));
                    
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return customers;
    }
    
    //ADD customer
    public boolean addCustomer(Customer customer) {
        query = "INSERT INTO customer(CustomerNIC, CustomerUsername, CustomerPassword, CustomerFirstName, CustomerLastName, CustomerEmail, CustomerPhoneNumber, CustomerLoginStatus, CustomerStatus) VALUES ('" + customer.getNic() +  "', '" + customer.getUsername() +  customer.getPassword()  +  customer.getFirstName() +  customer.getLastName() +  customer.getEmail() +  customer.getPhoneNumber() +  customer.getLoginStatus() +  customer.getCustomerStatus() + "')";
        try {
            dBInit =  DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
        
            int rows = statement.executeUpdate(query);
            
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
//    //UPDATE customer
//    public boolean updateCity(Customer customer) {
//        query = "UPDATE customer SET CustomerNIC = '" + city.getCityName()+ "', CityPhoneNumber = '" + city.getCityPhoneNumber() + "' WHERE (`id` = '"  + city.getCityID() + "')";
//        try {
//            dBInit =  DBConnection.getInstance();
//            statement = dBInit.dBConnectionInit();
//            
//            int rows = statement.executeUpdate(query);
//            return rows > 0;
//        } catch (SQLException e) {
//            System.out.println(e);
//        }  
//        return false;
//    }
    
}
