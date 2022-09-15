/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import project.onlinecabservice.service.model.Booking;
import project.onlinecabservice.service.model.BookingLocation;
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Customer;
import project.onlinecabservice.service.model.Driver;
import project.onlinecabservice.service.model.Street;
import project.onlinecabservice.service.model.Vehicle;
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
public class BookingDBTest {
    
    public BookingDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBooking method, of class BookingDB.
     */
    @Test
    public void testGetBooking() {
        System.out.println("getBooking");
        int id = 93002;
        BookingDB instance = BookingDB.getInstance();
        
        Customer customer = new Customer(32003, "V87678", "khloe45", "kkk9898", "Khloe", "Khanna", "khloek@gmail.com", 1111684776, "logged in", "idle");
        
        City drivercity = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Driver driver = new Driver(52005, "V654", "saman", "namas123", "Saman", "Sam", "sam@gmail.com", 1234567890, "logged in", "785874748", "available", drivercity);

        City vehicledrivercity = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Driver vehicledriver = new Driver(52005, "V654", "saman", "namas123", "Saman", "Sam", "sam@gmail.com", 1234567890, "logged in", "785874748", "available", vehicledrivercity);
        VehicleType vehicletype = new VehicleType(57008,"Bus", 10, 75);
        Vehicle vehicle = new Vehicle(27002, "75844J8", "WP7777", "6521764CD1", "white", "available", vehicletype, vehicledriver);
        
        City bookinglocationcitysource = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Street bookinglocationsource = new Street(75031, "Colombo 1", bookinglocationcitysource);
        City bookinglocationcitydestination = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Street bookinglocationdestination = new Street(75032, "Colombo 2", bookinglocationcitydestination);
        BookingLocation bookinglocation = new BookingLocation(83121, bookinglocationsource, bookinglocationdestination, 10);
        
        Booking expResult = new Booking(93002, 677, "completed", "17/9/2022-12:09", "Had a great time", "accepted", customer, driver, vehicle, bookinglocation);
        Booking result = instance.getBooking(id);
        
        assertEquals(expResult.getBookingID(), result.getBookingID());
        assertEquals(expResult.getPriceInLKR(), result.getPriceInLKR());
        assertEquals(expResult.getBookingStatus(), result.getBookingStatus());
        assertEquals(expResult.getBookingDateTime(), result.getBookingDateTime());
        assertEquals(expResult.getFeedback(), result.getFeedback());
        assertEquals(expResult.getIfAcceptedByDriver(), result.getIfAcceptedByDriver());
        
        assertEquals(expResult.getCustomer().getId(), result.getCustomer().getId());
        assertEquals(expResult.getCustomer().getNic(), result.getCustomer().getNic());
        assertEquals(expResult.getCustomer().getUsername(), result.getCustomer().getUsername());
        assertEquals(expResult.getCustomer().getPassword(), result.getCustomer().getPassword());
        assertEquals(expResult.getCustomer().getFirstName(), result.getCustomer().getFirstName());
        assertEquals(expResult.getCustomer().getLastName(), result.getCustomer().getLastName());
        assertEquals(expResult.getCustomer().getEmail(), result.getCustomer().getEmail());
        assertEquals(expResult.getCustomer().getPhoneNumber(), result.getCustomer().getPhoneNumber());
        assertEquals(expResult.getCustomer().getLoginStatus(), result.getCustomer().getLoginStatus());
        assertEquals(expResult.getCustomer().getCustomerStatus(), result.getCustomer().getCustomerStatus());
        
        assertEquals(expResult.getDriver().getId(), result.getDriver().getId());
        assertEquals(expResult.getDriver().getNic(), result.getDriver().getNic());
        assertEquals(expResult.getDriver().getUsername(), result.getDriver().getUsername());
        assertEquals(expResult.getDriver().getPassword(), result.getDriver().getPassword());
        assertEquals(expResult.getDriver().getFirstName(), result.getDriver().getFirstName());
        assertEquals(expResult.getDriver().getLastName(), result.getDriver().getLastName());
        assertEquals(expResult.getDriver().getEmail(), result.getDriver().getEmail());
        assertEquals(expResult.getDriver().getPhoneNumber(), result.getDriver().getPhoneNumber());
        assertEquals(expResult.getDriver().getLoginStatus(), result.getDriver().getLoginStatus());
        assertEquals(expResult.getDriver().getDriverLicenceID(), result.getDriver().getDriverLicenceID());
        assertEquals(expResult.getDriver().getDriverStatus(), result.getDriver().getDriverStatus());
        assertEquals(expResult.getDriver().getCity().getCityID(), result.getDriver().getCity().getCityID());
        assertEquals(expResult.getDriver().getCity().getCityName(), result.getDriver().getCity().getCityName());
        assertEquals(expResult.getDriver().getCity().getCityEmail(), result.getDriver().getCity().getCityEmail());
        assertEquals(expResult.getDriver().getCity().getCityPhoneNumber(), result.getDriver().getCity().getCityPhoneNumber());
        

        assertEquals(expResult.getVehicle().getVehicleID(), result.getVehicle().getVehicleID());
        assertEquals(expResult.getVehicle().getVehicleRegisterID(), result.getVehicle().getVehicleRegisterID());
        assertEquals(expResult.getVehicle().getVehicleNumber(), result.getVehicle().getVehicleNumber());
        assertEquals(expResult.getVehicle().getVehicleInsuranceID(), result.getVehicle().getVehicleInsuranceID());
        assertEquals(expResult.getVehicle().getVehicleColour(), result.getVehicle().getVehicleColour());
        assertEquals(expResult.getVehicle().getVehicleStatus(), result.getVehicle().getVehicleStatus());
        assertEquals(expResult.getVehicle().getDriver().getId(), result.getVehicle().getDriver().getId());
        assertEquals(expResult.getVehicle().getDriver().getNic(), result.getVehicle().getDriver().getNic());
        assertEquals(expResult.getVehicle().getDriver().getUsername(), result.getVehicle().getDriver().getUsername());
        assertEquals(expResult.getVehicle().getDriver().getPassword(), result.getVehicle().getDriver().getPassword());
        assertEquals(expResult.getVehicle().getDriver().getFirstName(), result.getVehicle().getDriver().getFirstName());
        assertEquals(expResult.getVehicle().getDriver().getLastName(), result.getVehicle().getDriver().getLastName());
        assertEquals(expResult.getVehicle().getDriver().getEmail(), result.getVehicle().getDriver().getEmail());
        assertEquals(expResult.getVehicle().getDriver().getPhoneNumber(), result.getVehicle().getDriver().getPhoneNumber());
        assertEquals(expResult.getVehicle().getDriver().getLoginStatus(), result.getVehicle().getDriver().getLoginStatus());
        assertEquals(expResult.getVehicle().getDriver().getDriverLicenceID(), result.getVehicle().getDriver().getDriverLicenceID());
        assertEquals(expResult.getVehicle().getDriver().getDriverStatus(), result.getVehicle().getDriver().getDriverStatus());
        assertEquals(expResult.getVehicle().getDriver().getCity().getCityID(), result.getVehicle().getDriver().getCity().getCityID());
        assertEquals(expResult.getVehicle().getDriver().getCity().getCityName(), result.getVehicle().getDriver().getCity().getCityName());
        assertEquals(expResult.getVehicle().getDriver().getCity().getCityEmail(), result.getVehicle().getDriver().getCity().getCityEmail());
        assertEquals(expResult.getVehicle().getDriver().getCity().getCityPhoneNumber(), result.getVehicle().getDriver().getCity().getCityPhoneNumber());
        assertEquals(expResult.getVehicle().getVehicleType().getTypeID(), result.getVehicle().getVehicleType().getTypeID());
        assertEquals(expResult.getVehicle().getVehicleType().getTypeName(), result.getVehicle().getVehicleType().getTypeName());
        assertEquals(expResult.getVehicle().getVehicleType().getVehicleCapacity(), result.getVehicle().getVehicleType().getVehicleCapacity());
        assertEquals(expResult.getVehicle().getVehicleType().getPricePerKmInLKR(), result.getVehicle().getVehicleType().getPricePerKmInLKR());
        
        assertEquals(expResult.getBookingLocations().getBookingLocationID(), result.getBookingLocations().getBookingLocationID());
        assertEquals(expResult.getBookingLocations().getDistanceInKm(), result.getBookingLocations().getDistanceInKm());
        assertEquals(expResult.getBookingLocations().getSource().getStreetID(), result.getBookingLocations().getSource().getStreetID());
        assertEquals(expResult.getBookingLocations().getSource().getStreetName(), result.getBookingLocations().getSource().getStreetName());
        assertEquals(expResult.getBookingLocations().getSource().getCity().getCityID(), result.getBookingLocations().getSource().getCity().getCityID());
        assertEquals(expResult.getBookingLocations().getSource().getCity().getCityName(), result.getBookingLocations().getSource().getCity().getCityName());
        assertEquals(expResult.getBookingLocations().getSource().getCity().getCityEmail(), result.getBookingLocations().getSource().getCity().getCityEmail());
        assertEquals(expResult.getBookingLocations().getSource().getCity().getCityPhoneNumber(), result.getBookingLocations().getSource().getCity().getCityPhoneNumber());
        assertEquals(expResult.getBookingLocations().getDestination().getStreetID(), result.getBookingLocations().getDestination().getStreetID());
        assertEquals(expResult.getBookingLocations().getDestination().getStreetName(), result.getBookingLocations().getDestination().getStreetName());
        assertEquals(expResult.getBookingLocations().getDestination().getCity().getCityID(), result.getBookingLocations().getDestination().getCity().getCityID());
        assertEquals(expResult.getBookingLocations().getDestination().getCity().getCityName(), result.getBookingLocations().getDestination().getCity().getCityName());
        assertEquals(expResult.getBookingLocations().getDestination().getCity().getCityEmail(), result.getBookingLocations().getDestination().getCity().getCityEmail());
        assertEquals(expResult.getBookingLocations().getDestination().getCity().getCityPhoneNumber(), result.getBookingLocations().getDestination().getCity().getCityPhoneNumber());
        
        
        
    }

    /**
     * Test of addBooking method, of class BookingDB.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");
        Booking booking = null;
        BookingDB instance = BookingDB.getInstance();
        boolean expResult = false;
        boolean result = instance.addBooking(booking);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateBooking method, of class BookingDB.
     */
    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        Booking booking = null;
        BookingDB instance = BookingDB.getInstance();
        boolean expResult = false;
        boolean result = instance.updateBooking(booking);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteBooking method, of class BookingDB.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        int id = 0;
        BookingDB instance = BookingDB.getInstance();
        boolean expResult = false;
        boolean result = instance.deleteBooking(id);
        assertEquals(expResult, result);
    }
    
}
