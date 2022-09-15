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
import project.onlinecabservice.service.model.City;
import project.onlinecabservice.service.model.Driver;
import project.onlinecabservice.service.model.Vehicle;
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
public class VehicleDBTest {
    
    public VehicleDBTest() {
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
     * Test of getVehicle method, of class VehicleDB.
     */
    @Test
    public void testGetVehicle() {
        System.out.println("getVehicle");
        int id = 27002;
        VehicleDB instance = VehicleDB.getInstance();
        
        City city = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        Driver driver = new Driver(52005, "V654", "saman", "namas123", "Saman", "Sam", "sam@gmail.com", 1234567890, "logged in", "785874748", "available", city);
        
        VehicleType type = new VehicleType(57008,"Bus", 10, 75);

        Vehicle expResult = new Vehicle(27002, "75844J8", "WP7777", "6521764CD1", "white", "available", type, driver);
        Vehicle result = instance.getVehicle(id);
        assertEquals(expResult.getVehicleID(), result.getVehicleID());
        assertEquals(expResult.getVehicleRegisterID(), result.getVehicleRegisterID());
        assertEquals(expResult.getVehicleNumber(), result.getVehicleNumber());
        assertEquals(expResult.getVehicleInsuranceID(), result.getVehicleInsuranceID());
        assertEquals(expResult.getVehicleColour(), result.getVehicleColour());
        assertEquals(expResult.getVehicleStatus(), result.getVehicleStatus());
        
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
        
        assertEquals(expResult.getVehicleType().getTypeID(), result.getVehicleType().getTypeID());
        assertEquals(expResult.getVehicleType().getTypeName(), result.getVehicleType().getTypeName());
        assertEquals(expResult.getVehicleType().getVehicleCapacity(), result.getVehicleType().getVehicleCapacity());
        assertEquals(expResult.getVehicleType().getPricePerKmInLKR(), result.getVehicleType().getPricePerKmInLKR());
    }

    /**
     * Test of addVehicle method, of class VehicleDB.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        Vehicle vehicle = null;
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = false;
        boolean result = instance.addVehicle(vehicle);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateVehicle method, of class VehicleDB.
     */
    @Test
    public void testUpdateVehicle() {
        System.out.println("updateVehicle");
        Vehicle vehicle = null;
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = false;
        boolean result = instance.updateVehicle(vehicle);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteVehicle method, of class VehicleDB.
     */
    @Test
    public void testDeleteVehicle() {
        System.out.println("deleteVehicle");
        int id = 0;
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = false;
        boolean result = instance.deleteVehicle(id);
        assertEquals(expResult, result);
    }
    
}
