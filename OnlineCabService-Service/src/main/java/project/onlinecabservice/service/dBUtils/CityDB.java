/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.onlinecabservice.service.model.City;

/**
 *
 * @author Sumaiya
 */
public class CityDB {
    
    //create an object of SingleObject
    private static CityDB instance = new CityDB();
   
    //make the constructor private so that this class cannot be instantiated
    private CityDB(){}
   
    //Get the only object available
    public static CityDB getInstance(){
       return instance;
    }
    
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    City city = null;
    
    //GET a city by its ID
    public City getCity(int id) {
        query = "call cabservicedatabase.getCity("+ id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                city = new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return city;
    }
    
    //GET all cities
    public List<City> getCities() {
        return null;
    }
    
    //ADD a city
    public boolean addCity(City city) {
        return false;
    }
    
    //UPDATE city
    public boolean updateCity(City city) {
        query = "UPDATE city SET CityName = '" + city.getCityName() + "', CityPhoneNumber = '" + city.getCityPhoneNumber() + "' WHERE (`CityID` = '"  + city.getCityID() + "')";
        try {
            dBInit =  DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            int rows = statement.executeUpdate(query);
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(e);
        }  
        return false;
    }
    
    //DELETE a city
    public boolean deleteCity(int id) {
        return false;
    }
    
    
    
    
    
}
