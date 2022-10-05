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
import project.onlinecabservice.service.dBUtils.AdminDB;
import project.onlinecabservice.service.model.Admin;

/**
 *
 * @author Sumaiya
 */
@Path("admin")
public class AdminService {
    AdminDB adminDB = null;
    GSON gsonSingleton = null;

    //GET a admin by its ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdmin(@PathParam("id") int id) {
        adminDB = AdminDB.getInstance();
        Admin admin = adminDB.getAdmin(id);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(admin);
    }
    
    //GET an admin by its username and password
    @GET
    @Path("/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdminFromUP(@PathParam("username") String username, @PathParam("password") String password) {
        adminDB = AdminDB.getInstance();
        Admin admin = adminDB.getAdminFromUP(username, password);

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(admin);
    }

    //GET all admins
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdmins() {
        adminDB = AdminDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        return gson.toJson(adminDB.getAdmins());
    }

    //ADD admin
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdmin(String json) {
        adminDB = AdminDB.getInstance();
        
        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();
        
        Admin admin = gson.fromJson(json, Admin.class);
        boolean result = adminDB.addAdmin(admin);

        if (result) {
            return Response.status(201).entity("Successfully added the admin!").build();
        } else {
            return Response.status(501).entity("Error occurred while adding the admin!").build();
        }
    }

    //UPDATE admin
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAdmin(String json) {
        adminDB = AdminDB.getInstance();

        gsonSingleton = GSON.getInstance();
        Gson gson = gsonSingleton.createGSON();

        Admin admin = gson.fromJson(json, Admin.class);

        boolean result = adminDB.updateAdmin(admin);

        if (result) {
            return Response.status(200).entity("Successfully updated the admin!").build();
        } else {
            return Response.status(501).entity("Error occurred while updating the admin!").build();
        }
    }

    //DELETE a admin by its ID
    @DELETE
    @Path("/{id}")
    public Response deleteAdmin(@PathParam("id") int id) {
        adminDB = AdminDB.getInstance();

        boolean result = adminDB.deleteAdmin(id);

        if (result) {
            return Response.status(200).entity("Successfully deleted the admin!").build();
        } else {
            return Response.status(501).entity("Error occurred while deleting the admin!").build();
        }
    }
    
}
