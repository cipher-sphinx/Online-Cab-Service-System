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
        VehicleType vehicletype = new VehicleType(57011, "Jeep", 5, 500);
        City city = new City(65016, "Weligama", "weligama@onlinecabservice.com", 1239865712);
        Driver driver = new Driver(52011, "V098", "asian", "may23", "May", "Nick", "nick@gmail.com", 1243826833, "logged in", "562321587", "available", city);

        Vehicle vehicle = new Vehicle(27004, "8686GF7", "NP7868", "87696GHYU6", "black", "available", vehicletype, driver);
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addVehicle(vehicle);
        assertEquals(expResult, result);

        //getting the object back to check the fields properly        
        Vehicle resultVehicle = instance.getVehicle(27004);
        
        assertEquals(vehicle.getVehicleID(), resultVehicle.getVehicleID());
        assertEquals(vehicle.getVehicleRegisterID(), resultVehicle.getVehicleRegisterID());
        assertEquals(vehicle.getVehicleNumber(), resultVehicle.getVehicleNumber());
        assertEquals(vehicle.getVehicleInsuranceID(), resultVehicle.getVehicleInsuranceID());
        assertEquals(vehicle.getVehicleColour(), resultVehicle.getVehicleColour());
        assertEquals(vehicle.getVehicleStatus(), resultVehicle.getVehicleStatus());
        assertEquals(vehicle.getDriver().getId(), resultVehicle.getDriver().getId());
        assertEquals(vehicle.getVehicleType().getTypeID(), resultVehicle.getVehicleType().getTypeID());
    }

    /**
     * Test of updateVehicle method, of class VehicleDB.
     */
    @Test
    public void testUpdateVehicle() {
        System.out.println("updateVehicle");
        
        VehicleType vehicletype = new VehicleType(57010, "CycleUpdated", 1, 30);
        City city = new City(65014, "HambantotaUpdated", "hamban@onlinecabservice.com", 117587555);
        Driver driver = new Driver(52004, "V746", "manhulkUpdated", "neo76", "Neo", "Manny", "manny@gmail.com", 1243823456, "logged in", "564R76587", "available", city);

        Vehicle vehicle = new Vehicle(27001, "675TY76Updated", "SP7868", "76576R68786", "black", "available", vehicletype, driver);
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateVehicle(vehicle);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Vehicle resultVehicle = instance.getVehicle(27001);
        
        assertEquals(vehicle.getVehicleID(), resultVehicle.getVehicleID());
        assertEquals(vehicle.getVehicleRegisterID(), resultVehicle.getVehicleRegisterID());
        assertEquals(vehicle.getVehicleNumber(), resultVehicle.getVehicleNumber());
        assertEquals(vehicle.getVehicleInsuranceID(), resultVehicle.getVehicleInsuranceID());
        assertEquals(vehicle.getVehicleColour(), resultVehicle.getVehicleColour());
        assertEquals(vehicle.getVehicleStatus(), resultVehicle.getVehicleStatus());
        assertEquals(vehicle.getDriver().getId(), resultVehicle.getDriver().getId());
        assertEquals(vehicle.getVehicleType().getTypeID(), resultVehicle.getVehicleType().getTypeID());
    }

    /**
     * Test of deleteVehicle method, of class VehicleDB.
     */
    @Test
    public void testDeleteVehicle() {
        System.out.println("deleteVehicle");
        int id = 27003;
        VehicleDB instance = VehicleDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteVehicle(id);
        assertEquals(expResult, result);
    }
    
}
