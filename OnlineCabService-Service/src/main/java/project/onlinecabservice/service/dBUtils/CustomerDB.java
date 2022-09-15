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
    
    //GET a customer by its ID
    public Customer getCustomer(int id) {
        return null;
    }
    
    //GET all customers
    public List<Customer> getCustomers() {
        return null;
    }
    
    //ADD a customer
    public boolean addCustomer(Customer customer) {
        return false;
    }
    
    //UPDATE a customer 
    public boolean updateCustomer(Customer customer) {
        return false;
    }
    
    //DELETE a customer
    public boolean deleteCustomer(int id) {
        return false;
    }
    
}
