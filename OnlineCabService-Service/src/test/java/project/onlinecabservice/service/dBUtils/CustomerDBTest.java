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
import project.onlinecabservice.service.model.Customer;

/**
 *
 * @author Sumaiya
 */
public class CustomerDBTest {
    
    public CustomerDBTest() {
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
     * Test of getCustomer method, of class CustomerDB.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        int id = 32003;
        CustomerDB instance = CustomerDB.getInstance();
        Customer expResult = new Customer(32003, "V87678", "khloe45", "kkk9898", "Khloe", "Khanna", "khloek@gmail.com", 1111684776, "logged in", "idle");
        Customer result = instance.getCustomer(id);
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getNic(), result.getNic());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(expResult.getLoginStatus(), result.getLoginStatus());
        assertEquals(expResult.getCustomerStatus(), result.getCustomerStatus());
        
    }

    /**
     * Test of addCustomer method, of class CustomerDB.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer customer = new Customer(32004, "V64323", "anncat", "anna647", "Anne", "Catty", "ancat@gmail.com", 1234595327, "logged in", "idle");
        CustomerDB instance = CustomerDB.getInstance();
        boolean expResult = true;
        boolean result = instance.addCustomer(customer);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Customer resultCustomer = instance.getCustomer(32004);
        
        assertEquals(customer.getId(), resultCustomer.getId());
        assertEquals(customer.getNic(), resultCustomer.getNic());
        assertEquals(customer.getUsername(), resultCustomer.getUsername());
        assertEquals(customer.getPassword(), resultCustomer.getPassword());
        assertEquals(customer.getFirstName(), resultCustomer.getFirstName());
        assertEquals(customer.getLastName(), resultCustomer.getLastName());
        assertEquals(customer.getEmail(), resultCustomer.getEmail());
        assertEquals(customer.getPhoneNumber(), resultCustomer.getPhoneNumber());
        assertEquals(customer.getLoginStatus(), resultCustomer.getLoginStatus());
        assertEquals(customer.getCustomerStatus(), resultCustomer.getCustomerStatus());
    }

    /**
     * Test of updateCustomer method, of class CustomerDB.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = new Customer(32002, "V64487", "stevezoro", "z1o1r1o1", "Steve", "Zoro", "steve@gmail.com", 1234568750, "logged in", "idle");
        CustomerDB instance = CustomerDB.getInstance();
        boolean expResult = true;
        boolean result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        
        //getting the object back to check the fields properly
        Customer resultCustomer = instance.getCustomer(32002);
        
        assertEquals(customer.getId(), resultCustomer.getId());
        assertEquals(customer.getNic(), resultCustomer.getNic());
        assertEquals(customer.getUsername(), resultCustomer.getUsername());
        assertEquals(customer.getPassword(), resultCustomer.getPassword());
        assertEquals(customer.getFirstName(), resultCustomer.getFirstName());
        assertEquals(customer.getLastName(), resultCustomer.getLastName());
        assertEquals(customer.getEmail(), resultCustomer.getEmail());
        assertEquals(customer.getPhoneNumber(), resultCustomer.getPhoneNumber());
        assertEquals(customer.getLoginStatus(), resultCustomer.getLoginStatus());
        assertEquals(customer.getCustomerStatus(), resultCustomer.getCustomerStatus());
    }

    /**
     * Test of deleteCustomer method, of class CustomerDB.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int id = 32008;
        CustomerDB instance = CustomerDB.getInstance();
        boolean expResult = true;
        boolean result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }
    
}
