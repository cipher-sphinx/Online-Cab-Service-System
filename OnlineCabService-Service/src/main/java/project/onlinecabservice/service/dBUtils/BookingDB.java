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
import project.onlinecabservice.service.model.Customer;
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
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    
    Customer customer = null;
    
    City driverCity = null;
    Driver driver = null;
    
    City vehicleDriverCity = null;
    Driver vehDriver = null;
    VehicleType vehicletype = null;
    Vehicle vehicle = null;
    
    City sourceCity = null;
    Street source = null;
    City destCity = null;
    Street destination = null;
    BookingLocation bookinglocation = null;
    
    Booking booking = null;
            

    //GET a booking by its id
    public Booking getBooking(int id) {
        query = "call cabservicedatabase.getBooking(" + id +")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                customer = new Customer(resultSet.getInt("CustomerID"), resultSet.getString("CustomerNIC"), resultSet.getString("CustomerUsername"), resultSet.getString("CustomerPassword"), resultSet.getString("CustomerFirstName"), resultSet.getString("CustomerLastName"),resultSet.getString("CustomerEmail"), resultSet.getInt("CustomerPhoneNumber"), resultSet.getString("CustomerLoginStatus"), resultSet.getString("CustomerStatus"));
                
                driverCity = new City(resultSet.getInt("DriverCityID"), resultSet.getString("DriverCityName"), resultSet.getString("DriverCityEmail"), resultSet.getInt("DriverCityPhoneNumber"));
                driver = new Driver(resultSet.getInt("DriverID"), resultSet.getString("DriverNIC"), resultSet.getString("DriverUsername"), resultSet.getString("DriverPassword"), resultSet.getString("DriverFirstName"), resultSet.getString("DriverLastName"), resultSet.getString("DriverEmail"), resultSet.getInt("DriverPhoneNumber"), resultSet.getString("DriverLoginStatus"), resultSet.getString("DriverLicenceID"), resultSet.getString("DriverStatus"), driverCity); 
                
                vehicleDriverCity = new City(resultSet.getInt("VehicleDriverCityID"), resultSet.getString("VehicleDriverCityName"), resultSet.getString("VehicleDriverCityEmail"), resultSet.getInt("VehicleDriverCityPhoneNumber"));
                vehDriver = new Driver(resultSet.getInt("VehicleDriverID"), resultSet.getString("VehicleDriverNIC"), resultSet.getString("VehicleDriverUsername"), resultSet.getString("VehicleDriverPassword"), resultSet.getString("VehicleDriverFirstName"), resultSet.getString("VehicleDriverLastName"), resultSet.getString("VehicleDriverEmail"), resultSet.getInt("VehicleDriverPhoneNumber"), resultSet.getString("VehicleDriverLoginStatus"), resultSet.getString("VehicleDriverLicenceID"), resultSet.getString("VehicleDriverStatus"), vehicleDriverCity); 
                vehicletype = new VehicleType(resultSet.getInt("TypeID"), resultSet.getString("TypeName"), resultSet.getInt("VehicleCapacity"), resultSet.getInt("PricePerKmInLKR"));
                vehicle = new Vehicle(resultSet.getInt("VehicleID"), resultSet.getString("VehicleRegisterID"), resultSet.getString("VehicleNumber"), resultSet.getString("VehicleInsuranceID"), resultSet.getString("VehicleColour"), resultSet.getString("VehicleStatus"), vehicletype, vehDriver);
                
                sourceCity = new City(resultSet.getInt("SourceCityID"), resultSet.getString("SourceCityName"), resultSet.getString("SourceCityEmail"), resultSet.getInt("SourceCityPhoneNumber"));
                source = new Street(resultSet.getInt("SourceID"), resultSet.getString("SourceName"), sourceCity);
                destCity = new City(resultSet.getInt("DestinationCityID"), resultSet.getString("DestinationCityName"), resultSet.getString("DestinationCityEmail"), resultSet.getInt("DestinationCityPhoneNumber"));
                destination = new Street(resultSet.getInt("DestinationID"), resultSet.getString("DestinationName"), destCity);
                bookinglocation = new BookingLocation(resultSet.getInt("BkLocationID"), source, destination, resultSet.getInt("BkDistanceInKm"));
                
                booking = new Booking(resultSet.getInt("BookingID"), resultSet.getInt("PriceInLKR"), resultSet.getString("BookingStatus"), resultSet.getString("BookingDateTime"), resultSet.getString("Feedback"), resultSet.getString("IfAcceptedByDriver"), customer, driver, vehicle,bookinglocation);
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return booking;
    }
    
    
    
}
