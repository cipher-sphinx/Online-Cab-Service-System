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
import project.onlinecabservice.service.dBUtils.BookingLocationDB;
import project.onlinecabservice.service.model.BookingLocation;

/**
 *
 * @author Sumaiya
 */
@Path("bookinglocation")
public class BookingLocationService {
    BookingLocationDB bookinglocationDB = null;
    GSON gsonSingleton = null;
   
    //GET a bookinglocation by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBookingLocation(@PathParam("id") int id) {
        bookinglocationDB = BookingLocationDB.getInstance();
        BookingLocation bookinglocation = bookinglocationDB.getBookingLocation(id);
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(bookinglocation);
    }
    
    //GET all bookinglocation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBookingLocations() {
        bookinglocationDB = BookingLocationDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(bookinglocationDB.getBookingLocations());
    }
    
    
    //ADD bookinglocation
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBookingLocation(String json) {
        bookinglocationDB = BookingLocationDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        BookingLocation bookinglocation = gson.fromJson(json, BookingLocation.class);
        boolean result = bookinglocationDB.addBookingLocation(bookinglocation);
        
        if (result) {
            return Response.status(201).entity("Successfully added the bookinglocation!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the bookinglocation!").build();
        }
    }
    
    //UPDATE bookinglocation
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBookingLocation(String json) {
        bookinglocationDB = BookingLocationDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        BookingLocation bookinglocation = gson.fromJson(json, BookingLocation.class);
        boolean result = bookinglocationDB.updateBookingLocation(bookinglocation);
        
        if (result) {
            return Response.status(200).entity("Successfully updated the bookinglocation!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the bookinglocation!").build();
        }
    }
    
    //DELETE a bookinglocation by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteBookingLocation(@PathParam("id") int id) {
        bookinglocationDB = BookingLocationDB.getInstance();
        
        boolean result = bookinglocationDB.deleteBookingLocation(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted the bookinglocation!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the bookinglocation!").build();
        }
    }
}
