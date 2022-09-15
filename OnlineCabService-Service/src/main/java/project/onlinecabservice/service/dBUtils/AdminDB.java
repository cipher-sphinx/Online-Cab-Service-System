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
    
    //GET an admin by its ID
    public Admin getAdmin(int id) {
        return null;
    }
    
    //GET all admins
    public List<Admin> getAdmins() {
        return null;
    }
    
    //ADD an admin
    public boolean addAdmin(Admin admin) {
        return false;
    }
    
    //UPDATE an admin 
    public boolean updateAdmin(Admin admin) {
        return false;
    }
    
    //DELETE an admin
    public boolean deleteAdmin(int id) {
        return false;
    }
    
    

    
}
