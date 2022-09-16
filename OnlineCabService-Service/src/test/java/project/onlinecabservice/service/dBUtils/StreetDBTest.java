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
        Street street = null;
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addStreet(street);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateStreet method, of class StreetDB.
     */
    @Test
    public void testUpdateStreet() {
        System.out.println("updateStreet");
        Street street = null;
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateStreet(street);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteStreet method, of class StreetDB.
     */
    @Test
    public void testDeleteStreet() {
        System.out.println("deleteStreet");
        int id = 0;
        StreetDB instance = StreetDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteStreet(id);
        assertEquals(expResult, result);
    }
    
}
