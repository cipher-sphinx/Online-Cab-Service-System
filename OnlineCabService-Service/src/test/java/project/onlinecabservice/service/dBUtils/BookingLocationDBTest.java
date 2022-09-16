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
import project.onlinecabservice.service.model.BookingLocation;
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Street;

/**
 *
 * @author Sumaiya
 */
public class BookingLocationDBTest {
    
    public BookingLocationDBTest() {
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
     * Test of getBookingLocation method, of class BookingLocationDB.
     */
    @Test
    public void testGetBookingLocation() {
        System.out.println("getBookingLocation");
        int id = 83121;
        BookingLocationDB instance = BookingLocationDB.getInstance();
        
        City citysource = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Street source = new Street(75031, "Colombo 1", citysource);
        
        City citydestination = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Street destination = new Street(75032, "Colombo 2", citydestination);
        
        BookingLocation expResult = new BookingLocation(83121, source, destination, 10);
        BookingLocation result = instance.getBookingLocation(id);
        
        assertEquals(expResult.getBookingLocationID(), result.getBookingLocationID());
        assertEquals(expResult.getDistanceInKm(), result.getDistanceInKm());
        
        assertEquals(expResult.getSource().getStreetID(), result.getSource().getStreetID());
        assertEquals(expResult.getSource().getStreetName(), result.getSource().getStreetName());
        
        assertEquals(expResult.getSource().getCity().getCityID(), result.getSource().getCity().getCityID());
        assertEquals(expResult.getSource().getCity().getCityName(), result.getSource().getCity().getCityName());
        assertEquals(expResult.getSource().getCity().getCityEmail(), result.getSource().getCity().getCityEmail());
        assertEquals(expResult.getSource().getCity().getCityPhoneNumber(), result.getSource().getCity().getCityPhoneNumber());
        
        assertEquals(expResult.getDestination().getStreetID(), result.getDestination().getStreetID());
        assertEquals(expResult.getDestination().getStreetName(), result.getDestination().getStreetName());
        
        assertEquals(expResult.getDestination().getCity().getCityID(), result.getDestination().getCity().getCityID());
        assertEquals(expResult.getDestination().getCity().getCityName(), result.getDestination().getCity().getCityName());
        assertEquals(expResult.getDestination().getCity().getCityEmail(), result.getDestination().getCity().getCityEmail());
        assertEquals(expResult.getDestination().getCity().getCityPhoneNumber(), result.getDestination().getCity().getCityPhoneNumber());
    }
    

    /**
     * Test of addBookingLocation method, of class BookingLocationDB.
     */
    @Test
    public void testAddBookingLocation() {
        System.out.println("addBookingLocation");
        BookingLocation bookinglocation = null;
        BookingLocationDB instance = BookingLocationDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addBookingLocation(bookinglocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateBookingLocation method, of class BookingLocationDB.
     */
    @Test
    public void testUpdateBookingLocation() {
        System.out.println("updateBookingLocation");
        BookingLocation bookinglocation = null;
        BookingLocationDB instance = BookingLocationDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateBookingLocation(bookinglocation);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteBookingLocation method, of class BookingLocationDB.
     */
    @Test
    public void testDeleteBookingLocation() {
        System.out.println("deleteBookingLocation");
        int id = 0;
        BookingLocationDB instance = BookingLocationDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteBookingLocation(id);
        assertEquals(expResult, result);
    }
    
}
