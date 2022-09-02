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
import project.onlinecabservice.service.dBUtils.StreetDB;
import project.onlinecabservice.service.model.Street;

/**
 *
 * @author Sumaiya
 */
@Path("street")
public class StreetService {
    StreetDB streetDB = null;
    GSON gsonSingleton = null;
   
    //GET a street by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStreet(@PathParam("id") int id) {
        streetDB = StreetDB.getInstance();
        Street street = streetDB.getStreet(id);
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(street);
    }
    
    //GET all streets
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStreets() {
        streetDB = StreetDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(streetDB.getStreets());
    }
    
    
    //ADD street
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStreet(String json) {
        streetDB = StreetDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Street street = gson.fromJson(json, Street.class);
        boolean result = streetDB.addStreet(street);
        
        if (result) {
            return Response.status(201).entity("Successfully added the street!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the street!").build();
        }
    }
    
    //UPDATE street
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStreet(String json) {
        streetDB = StreetDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Street street = gson.fromJson(json, Street.class);
        boolean result = streetDB.updateStreet(street);
        
        if (result) {
            return Response.status(200).entity("Successfully updated the street!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the street!").build();
        }
    }
    
    //DELETE a street by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteStreet(@PathParam("id") int id) {
        streetDB = StreetDB.getInstance();
        
        boolean result = streetDB.deleteStreet(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted the street!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the street!").build();
        }
    }
    
}
