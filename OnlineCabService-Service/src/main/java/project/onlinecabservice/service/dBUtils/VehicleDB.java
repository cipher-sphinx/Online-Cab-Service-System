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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    Driver driver = null;
    City city = null;
    VehicleType vehicletype = null;
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
                driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverLicenceID"), resultSet.getString("DriverStatus"), city);
                vehicletype = new VehicleType(resultSet.getInt("TypeID"), resultSet.getString("TypeName"), resultSet.getInt("VehicleCapacity"), resultSet.getInt("PricePerKmInLKR"));
                vehicle = new Vehicle(resultSet.getInt("VehicleID"), resultSet.getString("VehicleRegisterID"), resultSet.getString("VehicleNumber"), resultSet.getString("VehicleInsuranceID"), resultSet.getString("VehicleColour"), resultSet.getString("VehicleStatus"), vehicletype, driver);
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vehicle;
    }
    
    
    
    
}
