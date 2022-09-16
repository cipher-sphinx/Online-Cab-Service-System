/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Driver;

/**
 *
 * @author Sumaiya
 */
public class DriverDBTest {
    
    public DriverDBTest() {
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
     * Test of getDriver method, of class DriverDB.
     */
    @Test
    public void testGetDriver() {
        System.out.println("getDriver");
        int id = 52005;
        DriverDB instance = DriverDB.getInstance();
        City city = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Driver expResult = new Driver(52005, "V654", "saman", "namas123", "Saman", "Sam", "sam@gmail.com", 1234567890, "logged in", "785874748", "available", city);
        Driver result = instance.getDriver(id);
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getNic(), result.getNic());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(expResult.getLoginStatus(), result.getLoginStatus());
        assertEquals(expResult.getDriverLicenceID(), result.getDriverLicenceID());
        assertEquals(expResult.getDriverStatus(), result.getDriverStatus());
        
        assertEquals(expResult.getCity().getCityID(), result.getCity().getCityID());
        assertEquals(expResult.getCity().getCityName(), result.getCity().getCityName());
        assertEquals(expResult.getCity().getCityEmail(), result.getCity().getCityEmail());
        assertEquals(expResult.getCity().getCityPhoneNumber(), result.getCity().getCityPhoneNumber());
    }

    /**
     * Test of addDriver method, of class DriverDB.
     */
    @Test
    public void testAddDriver() {
        System.out.println("addDriver");
        
        City city = new City(65016, "Weligama", "weligama@onlinecabservice.com", 1239865712);
        Driver driver = new Driver(52011, "V098", "asian", "may23", "May", "Nick", "nick@gmail.com", 1243826833, "logged in", "562321587", "available", city);
        
        DriverDB instance = DriverDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addDriver(driver);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Driver resultDriver = instance.getDriver(52011);
        
        assertEquals(driver.getId(), resultDriver.getId());
        assertEquals(driver.getNic(), resultDriver.getNic());
        assertEquals(driver.getUsername(), resultDriver.getUsername());
        assertEquals(driver.getPassword(), resultDriver.getPassword());
        assertEquals(driver.getFirstName(), resultDriver.getFirstName());
        assertEquals(driver.getLastName(), resultDriver.getLastName());
        assertEquals(driver.getEmail(), resultDriver.getEmail());
        assertEquals(driver.getPhoneNumber(), resultDriver.getPhoneNumber());
        assertEquals(driver.getLoginStatus(), resultDriver.getLoginStatus());
        assertEquals(driver.getDriverStatus(), resultDriver.getDriverStatus());
        assertEquals(driver.getCity().getCityID(), resultDriver.getCity().getCityID());
    }

    /**
     * Test of updateDriver method, of class DriverDB.
     */
    @Test
    public void testUpdateDriver() {
        System.out.println("updateDriver");
        
        City city = new City(65014, "HambantotaUpdated", "hamban@onlinecabservice.com", 117587555);
        Driver driver = new Driver(52004, "V746", "manhulkUpdated", "neo76", "Neo", "Manny", "manny@gmail.com", 1243823456, "logged in", "564R76587", "available", city);
        
        DriverDB instance = DriverDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateDriver(driver);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Driver resultDriver = instance.getDriver(52004);
        
        assertEquals(driver.getId(), resultDriver.getId());
        assertEquals(driver.getNic(), resultDriver.getNic());
        assertEquals(driver.getUsername(), resultDriver.getUsername());
        assertEquals(driver.getPassword(), resultDriver.getPassword());
        assertEquals(driver.getFirstName(), resultDriver.getFirstName());
        assertEquals(driver.getLastName(), resultDriver.getLastName());
        assertEquals(driver.getEmail(), resultDriver.getEmail());
        assertEquals(driver.getPhoneNumber(), resultDriver.getPhoneNumber());
        assertEquals(driver.getLoginStatus(), resultDriver.getLoginStatus());
        assertEquals(driver.getDriverStatus(), resultDriver.getDriverStatus());
        assertEquals(driver.getCity().getCityID(), resultDriver.getCity().getCityID());
    }

    /**
     * Test of deleteDriver method, of class DriverDB.
     */
    @Test
    public void testDeleteDriver() {
        System.out.println("deleteDriver");
        int id = 52010;
        DriverDB instance = DriverDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteDriver(id);
        assertEquals(expResult, result);
    }
    
}
