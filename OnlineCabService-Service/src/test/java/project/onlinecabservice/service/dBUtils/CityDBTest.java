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

/**
 *
 * @author Sumaiya
 */
public class CityDBTest {
    
    public CityDBTest() {
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
     * Test of getCity method, of class CityDB.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        int id = 65013;
        CityDB instance = CityDB.getInstance();
        City expResult = new City(65013, "Colombo", "colombo@onlinecabservice.com", 111176488);
        City result = instance.getCity(id);
        
        assertEquals(expResult.getCityID(), result.getCityID());
        assertEquals(expResult.getCityName(), result.getCityName());
        assertEquals(expResult.getCityEmail(), result.getCityEmail());
        assertEquals(expResult.getCityPhoneNumber(), result.getCityPhoneNumber());
        
    }

    /**
     * Test of addCity method, of class CityDB.
     */
    @Test
    public void testAddCity() {
        System.out.println("addCity");
        City city = new City("AddCity", "addcity@onlinecabservice.com", 1239865712);
        CityDB instance = CityDB.getInstance();
        boolean expResult = false;
        boolean result = instance.addCity(city);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of updateCity method, of class CityDB.
     */
    @Test
    public void testUpdateCity() {
        System.out.println("updateCity");
        City city = null;
        CityDB instance = CityDB.getInstance();
        boolean expResult = false;
        boolean result = instance.updateCity(city);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteCity method, of class CityDB.
     */
    @Test
    public void testDeleteCity() {
        System.out.println("deleteCity");
        int id = 0;
        CityDB instance = CityDB.getInstance();
        boolean expResult = false;
        boolean result = instance.deleteCity(id);
        assertEquals(expResult, result);
    }
    
}
