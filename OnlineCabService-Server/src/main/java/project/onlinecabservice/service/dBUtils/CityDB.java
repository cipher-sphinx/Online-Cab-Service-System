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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    //GET a city by its ID
    public City getCity(int id) {
        City city = null;
        query = "SELECT * FROM city WHERE CityID = '" + id + " '";
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
        List<City> cities = new ArrayList<>();
        query = "SELECT * FROM city";
        try {
            dBInit =  DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            while(resultSet.next()) {
                City city = new City(Integer.parseInt(resultSet.getString("CityID")), resultSet.getString("CityName"), resultSet.getString("CityEmail"), Integer.parseInt(resultSet.getString("CityPhoneNumber")));
                cities.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }    
        return cities;
    }
    
    
    //ADD city
    public boolean addCity(City city) {
        query = "INSERT INTO city(CityID, CityName, CityPhoneNumber, CityEmail) VALUES ('" + city.getCityID() + city.getCityName()+  "', '" + city.getCityPhoneNumber() +  city.getCityEmail()  + "')";
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
    
    //UPDATE city
    public boolean updateCity(City city) {
        query = "UPDATE city SET CityName = '" + city.getCityName()+ "', CityPhoneNumber = '" + city.getCityPhoneNumber() + "' WHERE (`id` = '"  + city.getCityID() + "')";
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
    
    //DELETE a city by its ID
    public boolean deleteCity(int id) {
        query = "DELETE FROM city WHERE (CityID = '" + id + "');";
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
    
    
}
