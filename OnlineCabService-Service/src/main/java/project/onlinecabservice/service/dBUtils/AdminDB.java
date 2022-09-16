/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.onlinecabservice.service.model.Admin;

/**
 *
 * @author Sumaiya
 */
public class AdminDB {
    //create an object of SingleObject
    private static AdminDB instance = new AdminDB();
   
    //make the constructor private so that this class cannot be instantiated
    private AdminDB(){}
   
    //Get the only object available
    public static AdminDB getInstance(){
       return instance;
    }
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    Admin admin = null;
            
    //GET an admin by its id
    public Admin getAdmin(int id) {
        query = "call cabservicedatabase.getAdmin(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                admin = new Admin(resultSet.getInt("AdminID"), resultSet.getString("AdminNIC"), resultSet.getString("AdminUsername"), resultSet.getString("AdminPassword"), resultSet.getString("AdminFirstName"), resultSet.getString("AdminLastName"), resultSet.getString("AdminEmail"), resultSet.getInt("AdminPhoneNumber"), resultSet.getString("AdminLoginStatus"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return admin;
    }
    
    //GET all admins
    public List<Admin> getAdmins() {
        return null;
    }
    
    //ADD an admin
    public boolean addAdmin(Admin admin) {
        return false;
    }
    
    //UPDATE admin
    public boolean updateAdmin(Admin admin) {
        query = "UPDATE admin SET AdminNIC = '" + admin.getNic()+ "', AdminUsername = '" + admin.getUsername() + "', AdminPassword = '" + admin.getPassword() + "', AdminFirstName = '" + admin.getFirstName() + "', AdminLastName = '" + admin.getLastName() + "', AdminEmail = '" + admin.getEmail() + "', AdminPhoneNumber = '" + admin.getPhoneNumber() + "', AdminLoginStatus = '" + admin.getLoginStatus() + "' WHERE (`AdminID` = '"  + admin.getId()+ "')";
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
    
    //DELETE an admin
    public boolean deleteAdmin(int id) {
        return false;
    }
    
    

    
}
