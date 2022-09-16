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
import project.onlinecabservice.service.model.Street;

/**
 *
 * @author Sumaiya
 */
public class StreetDBTest {
    
    public StreetDBTest() {
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
     * Test of getStreet method, of class StreetDB.
     */
    @Test
    public void testGetStreet() {
        System.out.println("getStreet");
        int id = 75031;
        StreetDB instance = StreetDB.getInstance();
        
        City city = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        
        Street expResult = new Street(75031, "Colombo 1", city);
        Street result = instance.getStreet(id);
        
        assertEquals(expResult.getStreetID(), result.getStreetID());
        assertEquals(expResult.getStreetName(), result.getStreetName());
        
        assertEquals(expResult.getCity().getCityID(), result.getCity().getCityID());
        assertEquals(expResult.getCity().getCityName(), result.getCity().getCityName());
        assertEquals(expResult.getCity().getCityEmail(), result.getCity().getCityEmail());
        assertEquals(expResult.getCity().getCityPhoneNumber(), result.getCity().getCityPhoneNumber());
    }

    /**
     * Test of addStreet method, of class StreetDB.
     */
    @Test
    public void testAddStreet() {
        System.out.println("addStreet");
        
        City city = new City(65016, "Weligama", "weligama@onlinecabservice.com", 1239865712);
        Street street = new Street(75037, "Weligama 1", city);
        
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addStreet(street);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Street resultStreet = instance.getStreet(75037);
        
        assertEquals(street.getStreetID(), resultStreet.getStreetID());
        assertEquals(street.getStreetName(), resultStreet.getStreetName());
        assertEquals(street.getCity().getCityID(), resultStreet.getCity().getCityID());
    }

    /**
     * Test of updateStreet method, of class StreetDB.
     */
    @Test
    public void testUpdateStreet() {
        System.out.println("updateStreet");
        
        City city = new City(65014, "HambantotaUpdated", "hamban@onlinecabservice.com", 117587555);
        Street street = new Street(75033, "HambantotaUpdated 1", city);
        
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateStreet(street);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Street resultStreet = instance.getStreet(75033);
        
        assertEquals(street.getStreetID(), resultStreet.getStreetID());
        assertEquals(street.getStreetName(), resultStreet.getStreetName());
        assertEquals(street.getCity().getCityID(), resultStreet.getCity().getCityID());
        
    }

    /**
     * Test of deleteStreet method, of class StreetDB.
     */
    @Test
    public void testDeleteStreet() {
        System.out.println("deleteStreet");
        int id = 75036;
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteStreet(id);
        assertEquals(expResult, result);
    }
    
}
