/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.service;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import project.onlinecabservice.service.dBUtils.CustomerDB;
import project.onlinecabservice.service.model.Customer;

/**
 *
 * @author Sumaiya
 */
@Path("customer")
public class CustomerService {
    
    CustomerDB customerDB = null;
    GSON gsonSingleton = null;

    //GET a customer by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@PathParam("id") int id) {
        customerDB = CustomerDB.getInstance();
        Customer customer = customerDB.getCustomer(id);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(customer);
    }

    //GET all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomers() {
        customerDB = CustomerDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(customerDB.getCustomers());
    }

    //ADD customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(String json) {
        customerDB = CustomerDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Customer customer = gson.fromJson(json, Customer.class);
        boolean result = customerDB.addCustomer(customer);

        if (result) {
            return Response.status(201).entity("Successfully added the customer!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the customer!").build();
        }
    }

    //UPDATE customer
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(String json) {
        customerDB = CustomerDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        Customer customer = gson.fromJson(json, Customer.class);

        boolean result = customerDB.updateCustomer(customer);

        if (result) {
            return Response.status(200).entity("Successfully updated the customer!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the customer!").build();
        }
    }

    //DELETE a customer by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        customerDB = CustomerDB.getInstance();

        boolean result = customerDB.deleteCustomer(id);

        if (result) {
            return Response.status(200).entity("Successfully deleted the customer!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the customer!").build();
        }
    }

}
