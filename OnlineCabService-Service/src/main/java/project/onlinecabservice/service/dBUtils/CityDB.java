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
    
    
    //GET a city by its ID
    public City getCity(int id) {
        return null;
    }
    
    //GET all cities
    public List<City> getCities() {
        return null;
    }
    
    //ADD a city
    public boolean addCity(City city) {
        return false;
    }
    
    //UPDATE a city 
    public boolean updateCity(City city) {
        return false;
    }
    
    //DELETE a city
    public boolean deleteCity(int id) {
        return false;
    }
    
    
    
    
    
}
