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
import project.onlinecabservice.service.dBUtils.VehicleTypeDB;
import project.onlinecabservice.service.model.VehicleType;

/**
 *
 * @author Sumaiya
 */
@Path("vehicletype")
public class VehicleTypeService {
    VehicleTypeDB vehicletypeDB = null;
    GSON gsonSingleton = null;

    //GET a vehicletype by its id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicleType(@PathParam("id") int id) {
        vehicletypeDB = VehicleTypeDB.getInstance();
        VehicleType vehicletype = vehicletypeDB.getVehicleType(id);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(vehicletype);
    }


    //GET all vehicletypes
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getVehicleTypes() {
        vehicletypeDB = VehicleTypeDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(vehicletypeDB.getVehicleTypes());
    }


    //ADD vehicletype
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicleType(String json) {
        vehicletypeDB = VehicleTypeDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        VehicleType vehicletype = gson.fromJson(json, VehicleType.class);
        boolean result = vehicletypeDB.addVehicleType(vehicletype);

        if (result) {
            return Response.status(201).entity("Successfully added the vehicletype!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the vehicletype!").build();
        }
    }

 
    //UPDATE vehicletype
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVehicleType(String json) {
        vehicletypeDB = VehicleTypeDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        VehicleType vehicletype = gson.fromJson(json, VehicleType.class);

        boolean result = vehicletypeDB.updateVehicleType(vehicletype);

        if (result) {
            return Response.status(200).entity("Successfully updated the vehicletype!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the vehicletype!").build();
        }
    }


    //DELETE a vehicletype by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteVehicleType(@PathParam("id") int id) {
        vehicletypeDB = VehicleTypeDB.getInstance();

        boolean result = vehicletypeDB.deleteVehicleType(id);

        if (result) {
            return Response.status(200).entity("Successfully deleted the vehicletype!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the vehicletype!").build();
        }
    }
}
