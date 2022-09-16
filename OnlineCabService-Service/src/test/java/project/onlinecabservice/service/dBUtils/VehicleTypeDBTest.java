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
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
public class VehicleTypeDBTest {
    
    public VehicleTypeDBTest() {
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
     * Test of getVehicleType method, of class VehicleTypeDB.
     */
    @Test
    public void testGetVehicleType() {
        System.out.println("getVehicleType");
        int id = 57008;
        VehicleTypeDB instance = VehicleTypeDB.getInstance();
        VehicleType expResult = new VehicleType(57008,"Bus", 10, 75);
        VehicleType result = instance.getVehicleType(id);
        
        assertEquals(expResult.getTypeID(), result.getTypeID());
        assertEquals(expResult.getTypeName(), result.getTypeName());
        assertEquals(expResult.getVehicleCapacity(), result.getVehicleCapacity());
        assertEquals(expResult.getPricePerKmInLKR(), result.getPricePerKmInLKR());
    }

    /**
     * Test of addVehicleType method, of class VehicleTypeDB.
     */
    @Test
    public void testAddVehicleType() {
        System.out.println("addVehicleType");
        VehicleType vehicletype = new VehicleType(57011, "Jeep", 5, 500);
        VehicleTypeDB instance = VehicleTypeDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addVehicleType(vehicletype);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        VehicleType resultVehicleType = instance.getVehicleType(57011);
        
        assertEquals(vehicletype.getTypeID(), resultVehicleType.getTypeID());
        assertEquals(vehicletype.getTypeName(), resultVehicleType.getTypeName());
        assertEquals(vehicletype.getVehicleCapacity(), resultVehicleType.getVehicleCapacity());
        assertEquals(vehicletype.getPricePerKmInLKR(), resultVehicleType.getPricePerKmInLKR());
        
    }

    /**
     * Test of updateVehicleType method, of class VehicleTypeDB.
     */
    @Test
    public void testUpdateVehicleType() {
        System.out.println("updateVehicleType");
        VehicleType vehicletype = new VehicleType(57010, "CycleUpdated", 1, 30);
        VehicleTypeDB instance = VehicleTypeDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateVehicleType(vehicletype);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        VehicleType resultVehicleType = instance.getVehicleType(57010);
        
        assertEquals(vehicletype.getTypeID(), resultVehicleType.getTypeID());
        assertEquals(vehicletype.getTypeName(), resultVehicleType.getTypeName());
        assertEquals(vehicletype.getVehicleCapacity(), resultVehicleType.getVehicleCapacity());
        assertEquals(vehicletype.getPricePerKmInLKR(), resultVehicleType.getPricePerKmInLKR());
    }

    /**
     * Test of deleteVehicleType method, of class VehicleTypeDB.
     */
    @Test
    public void testDeleteVehicleType() {
        System.out.println("deleteVehicleType");
        int id = 57009;
        VehicleTypeDB instance = VehicleTypeDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteVehicleType(id);
        assertEquals(expResult, result);
    }
    
}
