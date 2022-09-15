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
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Driver;

/**
 *
 * @author Sumaiya
 */
public class DriverDB {
    
    //create an object of SingleObject
    private static DriverDB instance = new DriverDB();
   
    //make the constructor private so that this class cannot be instantiated
    private DriverDB(){}
   
    //Get the only object available
    public static DriverDB getInstance(){
       return instance;
    }
    
    //GET a driver by its ID
    public Driver getDriver(int id) {
        return null;
    }
    
    //GET all drivers
    public List<Driver> getDrivers() {
        return null;
    }
    
    //ADD a driver
    public boolean addDriver(Driver driver) {
        return false;
    }
    
    //UPDATE a driver 
    public boolean updateDriver(Driver driver) {
        return false;
    }
    
    //DELETE a driver
    public boolean deleteDriver(int id) {
        return false;
    }
    
    
    
    
}
