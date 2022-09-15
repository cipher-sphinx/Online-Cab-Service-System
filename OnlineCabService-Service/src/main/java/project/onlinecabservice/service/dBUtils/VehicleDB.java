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
import project.onlinecabservice.service.model.Vehicle;
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
public class VehicleDB {
    //create an object of SingleObject
    private static VehicleDB instance = new VehicleDB();
   
    //make the constructor private so that this class cannot be instantiated
    private VehicleDB(){}
   
    //Get the only object available
    public static VehicleDB getInstance(){
       return instance;
    }
    
    //GET a vehicle by its ID
    public Vehicle getVehicle(int id) {
        return null;
    }
    
    //GET all vehicles
    public List<Vehicle> getVehicles() {
        return null;
    }
    
    //ADD a vehicle
    public boolean addVehicle(Vehicle vehicle) {
        return false;
    }
    
    //UPDATE a vehicle 
    public boolean updateVehicle(Vehicle vehicle) {
        return false;
    }
    
    //DELETE a vehicle
    public boolean deleteVehicle(int id) {
        return false;
    }
    
    
    
    
}
