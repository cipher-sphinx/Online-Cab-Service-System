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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    Driver driver = null;
    City city = null;
    Vehicle vehicle = null;
            

    //GET a vehicle by its id
    public Vehicle getVehicle(int id) {
        query = "call cabservicedatabase.getVehicle(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                city = new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber"));
                driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverStatus"), city);
                vehicle = new Vehicle(resultSet.getInt("VehicleID"), resultSet.getString("VehicleRegisterID"), resultSet.getString("VehicleType"), resultSet.getInt("VehicleCapacity"), resultSet.getString("VehicleStatus"), driver);
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vehicle;
    }
    
    
    //GET all vehicles
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        query = "call cabservicedatabase.getAllVehicles()" ;
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                city = new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber"));
                driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverStatus"), city);
                vehicle = new Vehicle(resultSet.getInt("VehicleID"), resultSet.getString("VehicleRegisterID"), resultSet.getString("VehicleType"), resultSet.getInt("VehicleCapacity"), resultSet.getString("VehicleStatus"), driver);                    
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return vehicles;
    }
    
    
    //ADD vehicle
    public boolean addVehicle(Vehicle vehicle) {
        driver = new Driver(vehicle.getDriver().getId());
        query = "INSERT INTO vehicle(VehicleRegisterID, VehicleType, VehicleCapacity, VehicleStatus, DriverID) VALUES ('" + vehicle.getVehicleRegisterID()+  "', '" + vehicle.getVehicleType() +  "', '" +  vehicle.getVehicleCapacity() +  "', '" +  vehicle.getVehicleStatus() +  "', '" + driver.getId() +  "')";
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
    

    //UPDATE vehicle
    public boolean updateVehicle(Vehicle vehicle) {
        driver = new Driver(vehicle.getDriver().getId());
        query = "UPDATE vehicle SET VehicleRegisterID = '" + vehicle.getVehicleRegisterID() + "', VehicleType = '" + vehicle.getVehicleType() + "', VehicleCapacity = '" + vehicle.getVehicleCapacity() + "', VehicleStatus = '" + vehicle.getVehicleStatus() + "', DriverID = '" + driver.getId() + "' WHERE (`VehicleID` = '"  + vehicle.getVehicleID() + "')";
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
    
    
    //DELETE a vehicle by its ID
    public boolean deleteVehicle(int id) {
        query = "call cabservicedatabase.deleteVehicle(" + id + ")";
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
