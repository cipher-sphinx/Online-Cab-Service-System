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
import project.onlinecabservice.service.dBUtils.DriverDB;
import project.onlinecabservice.service.model.Driver;

/**
 *
 * @author Sumaiya
 */

@Path("driver")
public class DriverService {
    
    DriverDB driverDB = null;
    GSON gsonSingleton = null;

    //GET a driver by its id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDriver(@PathParam("id") int id) {
        driverDB = DriverDB.getInstance();
        Driver driver = driverDB.getDriver(id);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(driver);
    }
    
    //GET a driver by its username and password
    @GET
    @Path("/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDriverFromUP(@PathParam("username") String username, @PathParam("password") String password) {
        driverDB = DriverDB.getInstance();
        Driver driver = driverDB.getDriverFromUP(username, password);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(driver);
    }


    //GET all drivers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDrivers() {
        driverDB = DriverDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(driverDB.getDrivers());
    }


    //ADD driver
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver(String json) {
        driverDB = DriverDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Driver driver = gson.fromJson(json, Driver.class);
        boolean result = driverDB.addDriver(driver);

        if (result) {
            return Response.status(201).entity("Successfully added the driver!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the driver!").build();
        }
    }

 
    //UPDATE driver
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver(String json) {
        driverDB = DriverDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        Driver driver = gson.fromJson(json, Driver.class);

        boolean result = driverDB.updateDriver(driver);

        if (result) {
            return Response.status(200).entity("Successfully updated the driver!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the driver!").build();
        }
    }


    //DELETE a driver by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteDriver(@PathParam("id") int id) {
        driverDB = DriverDB.getInstance();

        boolean result = driverDB.deleteDriver(id);

        if (result) {
            return Response.status(200).entity("Successfully deleted the driver!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the driver!").build();
        }
    }
    
}
