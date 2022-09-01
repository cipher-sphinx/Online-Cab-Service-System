/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
            

    //GET a driver by its id
    public Driver getDriver(int id) {
        Driver driver = null;
        query = "SELECT DriverID, DriverNIC, DriverUsername, DriverPassword, DriverFirstName, DriverLastName, DriverEmail, DriverPhoneNumber, DriverLoginStatus, DriverStatus, driverV.CityID, cityV.CityName, cityV.CityEmail, cityV.CityPhoneNumber\n" + 
                "FROM driver driverV \n" +
                "JOIN city cityV ON driverV.CityID = cityV.CityID\n" +
                "WHERE DriverID = '" + id + "'";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverStatus"), new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber")));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return driver;
    }
    
    
    //GET all drivers
    public List<Driver> getDrivers() {
        List<Driver> drivers = new ArrayList<>();
        query = "SELECT DriverID, DriverNIC, DriverUsername, DriverPassword, DriverFirstName, DriverLastName, DriverEmail, DriverPhoneNumber, DriverLoginStatus, DriverStatus, driverV.CityID, cityV.CityName, cityV.CityEmail, cityV.CityPhoneNumber\n" + 
                "FROM driver driverV \n" +
                "JOIN city cityV ON driverV.CityID = cityV.CityID" ;
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                Driver driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverStatus"), new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber")));
                    
                drivers.add(driver);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return drivers;
    }
    
    
    //ADD driver
    public boolean addDriver(Driver driver) {
        City city = new City(driver.getCity().getCityID());
        query = "INSERT INTO driver(DriverNIC, DriverUsername, DriverPassword, DriverFirstName, DriverLastName, DriverEmail, DriverPhoneNumber, DriverLoginStatus, DriverStatus, CityID) VALUES ('" + driver.getNic() +  "', '" + driver.getUsername() +  "', '" +  driver.getPassword()  +  "', '" +  driver.getFirstName() +  "', '" +  driver.getLastName() +  "', '" +  driver.getEmail() +  "', '" +  driver.getPhoneNumber() +  "', '" +  driver.getLoginStatus() +  "', '" +  driver.getDriverStatus() +  "', '" + city.getCityID() +  "')";
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
    

    //UPDATE driver
    public boolean updateDriver(Driver driver) {
        City city = new City(driver.getCity().getCityID());
        query = "UPDATE driver SET DriverNIC = '" + driver.getNic()+ "', DriverUsername = '" + driver.getUsername() + "', DriverPassword = '" + driver.getPassword() + "', DriverFirstName = '" + driver.getFirstName() + "', DriverLastName = '" + driver.getLastName() + "', DriverEmail = '" + driver.getEmail() + "', DriverPhoneNumber = '" + driver.getPhoneNumber() + "', DriverLoginStatus = '" + driver.getLoginStatus() + "', DriverStatus = '" + driver.getDriverStatus() + "', CityID = '"+ city.getCityID() + "' WHERE (`DriverID` = '"  + driver.getId()+ "')";
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
    
    
    //DELETE a driver by its ID
    public boolean deleteDriver(int id) {
        query = "DELETE FROM driver WHERE (DriverID = '" + id + "');";
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
