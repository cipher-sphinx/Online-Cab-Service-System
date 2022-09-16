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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    City sourceCity = null;
    Street source = null;
    
    City destCity = null;
    Street destination = null;
    
    BookingLocation bookinglocation = null;
 
    //GET a bookinglocation by its ID
    public BookingLocation getBookingLocation(int id) {
        query = "call cabservicedatabase.getBookingLocation(" + id +")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                sourceCity = new City(resultSet.getInt("SourceCityID"), resultSet.getString("SourceCityName"), resultSet.getString("SourceCityEmail"), resultSet.getInt("SourceCityPhoneNumber"));
                source = new Street(resultSet.getInt("SourceID"), resultSet.getString("SourceName"), sourceCity);
                destCity = new City(resultSet.getInt("DestinationCityID"), resultSet.getString("DestinationCityName"), resultSet.getString("DestinationCityEmail"), resultSet.getInt("DestinationCityPhoneNumber"));
                destination = new Street(resultSet.getInt("DestinationID"), resultSet.getString("DestinationName"), destCity);
                bookinglocation = new BookingLocation(resultSet.getInt("BkLocationID"), source, destination, resultSet.getInt("BkDistanceInKm"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bookinglocation;
    }
    
    //GET all bookinglocations
    public List<BookingLocation> getBookingLocations() {
        return null;
    }
    
    //ADD bookinglocation
    public boolean addBookingLocation(BookingLocation bookinglocation) {
        source = new Street(bookinglocation.getSource().getStreetID());
        destination = new Street(bookinglocation.getSource().getStreetID());
        query = "INSERT INTO bookinglocation(BkSourceID, BkDestinationID, BkDistanceInKm) VALUES ('"+ source.getStreetID() +  "', '" + destination.getStreetID() + "', '" + bookinglocation.getDistanceInKm() + "')";
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
    
    //UPDATE bookinglocation
    public boolean updateBookingLocation(BookingLocation bookinglocation) {
        source = new Street(bookinglocation.getSource().getStreetID());
        destination = new Street(bookinglocation.getDestination().getStreetID());        
        query = "UPDATE bookinglocation SET BkSourceID = '" + source.getStreetID() + "', BkDestinationID = '" + destination.getStreetID() + "', BkDistanceInKm = '" + bookinglocation.getDistanceInKm() + "' WHERE (`BkLocationID` = '"  + bookinglocation.getBookingLocationID()+ "')";
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
    
    //DELETE a bookinglocation by its ID
    public boolean deleteBookingLocation(int id) {
        query = "call cabservicedatabase.deleteBookingLocation(" + id + ")";
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
