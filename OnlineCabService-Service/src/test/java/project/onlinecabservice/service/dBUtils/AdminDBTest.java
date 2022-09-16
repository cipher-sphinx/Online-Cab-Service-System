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
import project.onlinecabservice.service.model.Admin;

/**
 *
 * @author Sumaiya
 */
public class AdminDBTest {
    
    public AdminDBTest() {
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
     * Test of getAdmin method, of class AdminDB.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        int id = 42004;
        AdminDB instance = AdminDB.getInstance();
        Admin expResult = new Admin(42004, "V1234", "kristenjohn", "KJ@12344", "Kristen", "John", "kj@gmail.com", 1111677467, "logged in");
        Admin result = instance.getAdmin(id);
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getNic(), result.getNic());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(expResult.getLoginStatus(), result.getLoginStatus());
        
    }

    /**
     * Test of addAdmin method, of class AdminDB.
     */
    @Test
    public void testAddAdmin() {
        System.out.println("addAdmin");
        Admin admin = new Admin(42007, "V6758", "monicamas", "monica7647", "Monica", "Sam", "monica@gmail.com", 116546575, "logged in");
        AdminDB instance = AdminDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addAdmin(admin);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Admin resultAdmin = instance.getAdmin(42007);
        
        assertEquals(admin.getId(), resultAdmin.getId());
        assertEquals(admin.getNic(), resultAdmin.getNic());
        assertEquals(admin.getUsername(), resultAdmin.getUsername());
        assertEquals(admin.getPassword(), resultAdmin.getPassword());
        assertEquals(admin.getFirstName(), resultAdmin.getFirstName());
        assertEquals(admin.getLastName(), resultAdmin.getLastName());
        assertEquals(admin.getEmail(), resultAdmin.getEmail());
        assertEquals(admin.getPhoneNumber(), resultAdmin.getPhoneNumber());
        assertEquals(admin.getLoginStatus(), resultAdmin.getLoginStatus());

    }

    /**
     * Test of updateAdmin method, of class AdminDB.
     */
    @Test
    public void testUpdateAdmin() {
        System.out.println("updateAdmin");
        Admin admin = new Admin(42005, "V6752", "stella89Updated", "8769stella", "Stella", "Bruce", "bru@gmail.com", 1165465374, "logged in");
        AdminDB instance = AdminDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateAdmin(admin);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Admin resultAdmin = instance.getAdmin(42005);
        
        assertEquals(admin.getId(), resultAdmin.getId());
        assertEquals(admin.getNic(), resultAdmin.getNic());
        assertEquals(admin.getUsername(), resultAdmin.getUsername());
        assertEquals(admin.getPassword(), resultAdmin.getPassword());
        assertEquals(admin.getFirstName(), resultAdmin.getFirstName());
        assertEquals(admin.getLastName(), resultAdmin.getLastName());
        assertEquals(admin.getEmail(), resultAdmin.getEmail());
        assertEquals(admin.getPhoneNumber(), resultAdmin.getPhoneNumber());
        assertEquals(admin.getLoginStatus(), resultAdmin.getLoginStatus());
    }

    /**
     * Test of deleteAdmin method, of class AdminDB.
     */
    @Test
    public void testDeleteAdmin() {
        System.out.println("deleteAdmin");
        int id = 42006;
        AdminDB instance = AdminDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteAdmin(id);
        assertEquals(expResult, result);
    }
    
}
