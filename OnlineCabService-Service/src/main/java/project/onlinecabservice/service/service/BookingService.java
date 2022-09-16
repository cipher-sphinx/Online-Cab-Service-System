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
import project.onlinecabservice.service.dBUtils.BookingDB;
import project.onlinecabservice.service.model.Booking;

/**
 *
 * @author Sumaiya
 */
@Path("booking")
public class BookingService {
    BookingDB bookingDB = null;
    GSON gsonSingleton = null;
   
    //GET a booking by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBooking(@PathParam("id") int id) {
        bookingDB = BookingDB.getInstance();
        Booking booking = bookingDB.getBooking(id);
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(booking);
    }
    
    //GET all booking
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBookings() {
        bookingDB = BookingDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        return gson.toJson(bookingDB.getBookings());
    }
    
    
    //ADD booking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(String json) {
        bookingDB = BookingDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Booking booking = gson.fromJson(json, Booking.class);
        boolean result = bookingDB.addBooking(booking);
        
        if (result) {
            return Response.status(201).entity("Successfully added the booking!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the booking!").build();
        }
    }
    
    //UPDATE booking
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBooking(String json) {
        bookingDB = BookingDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Booking booking = gson.fromJson(json, Booking.class);
        boolean result = bookingDB.updateBooking(booking);
        
        if (result) {
            return Response.status(200).entity("Successfully updated the booking!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the booking!").build();
        }
    }
    
    //DELETE a booking by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") int id) {
        bookingDB = BookingDB.getInstance();
        
        boolean result = bookingDB.deleteBooking(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted the booking!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the booking!").build();
        }
    }
    
}
