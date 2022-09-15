/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.dBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.onlinecabservice.service.model.VehicleType;


/**
 *
 * @author Sumaiya
 */
public class VehicleTypeDB {
    //create an object of SingleObject
    private static VehicleTypeDB instance = new VehicleTypeDB();
   
    //make the constructor private so that this class cannot be instantiated
    private VehicleTypeDB(){}
   
    //Get the only object available
    public static VehicleTypeDB getInstance(){
       return instance;
    }
    
    DBConnection dBInit = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String query = "";
    VehicleType vehicletype = null;
            

    //GET a vehicletype by its id
    public VehicleType getVehicleType(int id) {
        query = "call cabservicedatabase.getVehicleType(" + id + ")";
        try {
            dBInit = DBConnection.getInstance();
            statement = dBInit.dBConnectionInit();
            
            resultSet = statement.executeQuery(query);
            
            // Extract data from result set
            while(resultSet.next()) {
                // Retrieve by column name
                vehicletype = new VehicleType(resultSet.getInt("TypeID"), resultSet.getString("TypeName"), resultSet.getInt("VehicleCapacity"), resultSet.getInt("PricePerKmInLKR"));
            }   
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vehicletype;
    }
    
    
    
    
}
