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
import project.onlinecabservice.service.model.BookingLocation;
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Street;


/**
 *
 * @author Sumaiya
 */
public class BookingLocationDB {
    //create an object of SingleObject
    private static BookingLocationDB instance = new BookingLocationDB();
   
    //make the constructor private so that this class cannot be instantiated
    private BookingLocationDB(){}
   
    //Get the only object available
    public static BookingLocationDB getInstance(){
       return instance;
    }
    
    //GET a bookinglocation by its ID
    public BookingLocation getBookingLocation(int id) {
        return null;
    }
    
    //GET all bookinglocations
    public List<BookingLocation> getBookingLocations() {
        return null;
    }
    
    //ADD a bookinglocation
    public boolean addBookingLocation(BookingLocation bookinglocation) {
        return false;
    }
    
    //UPDATE a bookinglocation 
    public boolean updateBookingLocation(BookingLocation bookinglocation) {
        return false;
    }
    
    //DELETE a bookinglocation
    public boolean deleteBookingLocation(int id) {
        return false;
    }
 
    
    
    
    
}
