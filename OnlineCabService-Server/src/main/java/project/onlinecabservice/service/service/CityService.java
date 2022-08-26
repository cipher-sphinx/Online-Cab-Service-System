/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import project.onlinecabservice.service.dBUtils.CityDB;
import project.onlinecabservice.service.model.City;

/**
 *
 * @author Sumaiya
 */
@Path("city")
public class CityService {
   
    //GET a city by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCity(@PathParam("id") int id) {
        CityDB cityDB = new CityDB();
        City city = cityDB.getCity(id);
        
        Gson gson = new GsonBuilder().create();
        
        return gson.toJson(city);
//        or could also say return gson.toJson(cityDB.getCity(id)); without creating a city object        
//        return Response.status(200).entity(city.getCityName()).build();
//        return Response.status(200).entity("Hello World").build();
    }
    
    //GET all cities
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCities() {
        CityDB cityDB = new CityDB();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(cityDB.getCities());
    }
    
    
    //ADD city
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCity(String json) {
        CityDB cityDB = new CityDB();
        Gson gson = new GsonBuilder().create();
        City city = gson.fromJson(json, City.class);
        boolean result = cityDB.addCity(city);
        
        if (result) {
            return Response.status(201).entity("Successfully added the city!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the city!").build();
        }
    }
    
    //UPDATE city
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(String json) {
        CityDB cityDB = new CityDB();
        Gson gson = new GsonBuilder().create();
        City city = gson.fromJson(json, City.class);
        boolean result = cityDB.updateCity(city);
        
        if (result) {
            return Response.status(200).entity("Successfully updated the city!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the city!").build();
        }
    }
    
    //DELETE a city by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteCity(@PathParam("id") int id) {
        CityDB cityDB = new CityDB();
        boolean result = cityDB.deleteCity(id);
        if (result) {
            return Response.status(200).entity("Successfully deleted the city!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the city!").build();
        }
    }
}
