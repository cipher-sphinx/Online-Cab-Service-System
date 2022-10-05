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
    
    //GET a customer by its username and password
    public Customer getCustomerFromUP(String username, String password) {
        query = "SELECT * FROM customer WHERE CustomerUsername = '" + username + "' AND CustomerPassword = '" + password +"'";
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
    
    //GET all customers
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        query = "call cabservicedatabase.getAllcustomers()";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                customer = new Customer(resultSet.getInt("CustomerID"), resultSet.getString("CustomerNIC"), resultSet.getString("CustomerUsername"), resultSet.getString("CustomerPassword"), resultSet.getString("CustomerFirstName"), resultSet.getString("CustomerLastName"), resultSet.getString("CustomerEmail"), resultSet.getInt("CustomerPhoneNumber"), resultSet.getString("CustomerLoginStatus"), resultSet.getString("CustomerStatus"));
                    
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return customers;
    }
    
    //ADD customer
    public boolean addCustomer(Customer customer) {
        query = "INSERT INTO customer(CustomerNIC, CustomerUsername, CustomerPassword, CustomerFirstName, CustomerLastName, CustomerEmail, CustomerPhoneNumber, CustomerLoginStatus, CustomerStatus) VALUES ('" + customer.getNic() +  "', '" + customer.getUsername() +  "', '"  +  customer.getPassword() +  "', '" +  customer.getFirstName()  +  "', '"  +  customer.getLastName()  +  "', '"  +  customer.getEmail()  +  "', '"  +  customer.getPhoneNumber()  +  "', '"  +  customer.getLoginStatus()  +  "', '"  +  customer.getCustomerStatus() + "')";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
        
            int rows = statement.executeUpdate(query);
            
            
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    //UPDATE customer
    public boolean updateCustomer(Customer customer) {
        query = "UPDATE customer SET CustomerNIC = '" + customer.getNic()+ "', CustomerUsername = '" + customer.getUsername() + "', CustomerPassword = '" + customer.getPassword() + "', CustomerFirstName = '" + customer.getFirstName() + "', CustomerLastName = '" + customer.getLastName() + "', CustomerEmail = '" + customer.getEmail() + "', CustomerPhoneNumber = '" + customer.getPhoneNumber() + "', CustomerLoginStatus = '" + customer.getLoginStatus() + "', CustomerStatus = '" + customer.getCustomerStatus() + "' WHERE (`CustomerID` = '"  + customer.getId()+ "')";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            int rows = statement.executeUpdate(query);
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    //DELETE a customer by its ID
    public boolean deleteCustomer(int id) {
        query = "call cabservicedatabase.deleteCustomer(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            int rows = statement.executeUpdate(query);
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
}
