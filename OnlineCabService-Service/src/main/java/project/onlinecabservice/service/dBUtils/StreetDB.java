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
import project.onlinecabservice.service.model.Street;

/**
 *
 * @author Sumaiya
 */
public class StreetDB {
    //create an object of SingleObject
    private static StreetDB instance = new StreetDB();
   
    //make the constructor private so that this class cannot be instantiated
    private StreetDB(){}
   
    //Get the only object available
    public static StreetDB getInstance(){
       return instance;
    }
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    City city = null;
    Street street = null;
 
    //GET a street by its ID
    public Street getStreet(int id) {
        query = "call cabservicedatabase.getStreet(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                city = new City(resultSet.getInt("CityID"), resultSet.getString("CityName"), resultSet.getString("CityEmail"), resultSet.getInt("CityPhoneNumber"));
                street = new Street(resultSet.getInt("StreetID"), resultSet.getString("StreetName"), city);
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return street;
    }
    
    
    
    
}
