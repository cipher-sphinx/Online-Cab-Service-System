/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class Vehicle {
    private int vehicleID;
    private String vehicleRegisterID;
    private String vehicleNumber;
    private String vehicleInsuranceID;
    private String vehicleColour;
    private String vehicleStatus;
    private VehicleType vehicleType;
    private Driver driver;
    

    public Vehicle(int vehicleID, String vehicleRegisterID, String vehicleNumber, String vehicleInsuranceID, String vehicleColour, String vehicleStatus, VehicleType vehicleType, Driver driver) {
        this.vehicleID = vehicleID;
        this.vehicleRegisterID = vehicleRegisterID;
        this.vehicleNumber = vehicleNumber;
        this.vehicleInsuranceID = vehicleInsuranceID;
        this.vehicleColour = vehicleColour;
        this.vehicleStatus = vehicleStatus;
        this.driver = driver;
        this.vehicleType = vehicleType;
    }


    public Vehicle(int vehicleID) {
        this.vehicleID = vehicleID;
    }
    

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleRegisterID() {
        return vehicleRegisterID;
    }

    public void setVehicleRegisterID(String vehicleRegisterID) {
        this.vehicleRegisterID = vehicleRegisterID;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleInsuranceID() {
        return vehicleInsuranceID;
    }

    public void setVehicleInsuranceID(String vehicleInsuranceID) {
        this.vehicleInsuranceID = vehicleInsuranceID;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
}
