/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class Customer extends User{
    private String customerStatus;

    public Customer(int id, String nic, String username, String password, String firstName, String lastName, String email, int phoneNumber, String loginStatus, String customerStatus) {
        super(id, nic, username, password, firstName, lastName, email, phoneNumber, loginStatus);
        this.customerStatus = customerStatus;
    }
    
    

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public void login() {
    }

    @Override
    public void verifyLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewProfile() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
