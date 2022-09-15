/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            
    
    
}
