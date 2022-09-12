/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class VehicleType {
    private int TypeID;
    private String TypeName;
    private int vehicleCapacity;
    private int pricePerKmInLKR;

    public VehicleType(int TypeID) {
        this.TypeID = TypeID;
    }

    public VehicleType(int TypeID, String TypeName, int vehicleCapacity, int pricePerKmInLKR) {
        this.TypeID = TypeID;
        this.TypeName = TypeName;
        this.vehicleCapacity = vehicleCapacity;
        this.pricePerKmInLKR = pricePerKmInLKR;
    }

    
    

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public int getPricePerKmInLKR() {
        return pricePerKmInLKR;
    }

    public void setPricePerKmInLKR(int pricePerKmInLKR) {
        this.pricePerKmInLKR = pricePerKmInLKR;
    }
    
    
    
}
