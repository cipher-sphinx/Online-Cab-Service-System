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
import project.onlinecabservice.service.model.Booking;
import project.onlinecabservice.service.model.BookingLocation;
import project.onlinecabservice.service.model.Booking;
import project.onlinecabservice.service.model.Driver;
import project.onlinecabservice.service.model.Street;
import project.onlinecabservice.service.model.Vehicle;
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
public class BookingDB {
    //create an object of SingleObject
    private static BookingDB instance = new BookingDB();
   
    //make the constructor private so that this class cannot be instantiated
    private BookingDB(){}
   
    //Get the only object available
    public static BookingDB getInstance(){
       return instance;
    }
    
   //GET a booking by its ID
    public Booking getBooking(int id) {
        return null;
    }
    
    //GET all bookings
    public List<Booking> getBookings() {
        return null;
    }
    
    //ADD a booking
    public boolean addBooking(Booking booking) {
        return false;
    }
    
    //UPDATE a booking 
    public boolean updateBooking(Booking booking) {
        return false;
    }
    
    //DELETE a booking
    public boolean deleteBooking(int id) {
        return false;
    }
    
    
    
}
