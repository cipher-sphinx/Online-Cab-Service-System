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
import project.onlinecabservice.service.dBUtils.VehicleDB;
import project.onlinecabservice.service.model.Vehicle;

/**
 *
 * @author Sumaiya
 */
public class VehicleService {
    VehicleDB vehicleDB = null;
    GSON gsonSingleton = null;

    //GET a vehicle by its id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicle(@PathParam("id") int id) {
        vehicleDB = VehicleDB.getInstance();
        Vehicle vehicle = vehicleDB.getVehicle(id);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(vehicle);
    }


    //GET all vehicles
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicles() {
        vehicleDB = VehicleDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(vehicleDB.getVehicles());
    }


    //ADD vehicle
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(String json) {
        vehicleDB = VehicleDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Vehicle vehicle = gson.fromJson(json, Vehicle.class);
        boolean result = vehicleDB.addVehicle(vehicle);

        if (result) {
            return Response.status(201).entity("Successfully added the vehicle!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the vehicle!").build();
        }
    }

 
    //UPDATE vehicle
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVehicle(String json) {
        vehicleDB = VehicleDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        Vehicle vehicle = gson.fromJson(json, Vehicle.class);

        boolean result = vehicleDB.updateVehicle(vehicle);

        if (result) {
            return Response.status(200).entity("Successfully updated the vehicle!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the vehicle!").build();
        }
    }


    //DELETE a vehicle by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteVehicle(@PathParam("id") int id) {
        vehicleDB = VehicleDB.getInstance();

        boolean result = vehicleDB.deleteVehicle(id);

        if (result) {
            return Response.status(200).entity("Successfully deleted the vehicle!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the vehicle!").build();
        }
    }
    
}
