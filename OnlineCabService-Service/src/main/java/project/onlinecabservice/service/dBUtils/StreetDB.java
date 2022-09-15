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
    
    //GET a street by its ID
    public Street getStreet(int id) {
        return null;
    }
    
    //GET all streets
    public List<Street> getStreets() {
        return null;
    }
    
    //ADD a street
    public boolean addStreet(Street street) {
        return false;
    }
    
    //UPDATE a street 
    public boolean updateStreet(Street street) {
        return false;
    }
    
    //DELETE a street
    public boolean deleteStreet(int id) {
        return false;
    }
    
    
    
    
}
