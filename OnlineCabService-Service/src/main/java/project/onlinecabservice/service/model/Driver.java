/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class Driver extends User{
    private String DriverLicenceID;
    private String driverStatus;
    private City city;

    public Driver(int id, String nic, String username, String password, String firstName, String lastName, String email, int phoneNumber, String loginStatus, String DriverLicenceID, String driverStatus, City city) {
        super(id, nic, username, password, firstName, lastName, email, phoneNumber, loginStatus);
        this.driverStatus = driverStatus;
        this.DriverLicenceID = DriverLicenceID;
        this.city = city;
    }
    
    
    public Driver(int id) {
        super(id);
    }
    
    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDriverLicenceID() {
        return DriverLicenceID;
    }

    public void setDriverLicenceID(String DriverLicenceID) {
        this.DriverLicenceID = DriverLicenceID;
    }
    
    @Override
    public void login() {
    }
    
    @Override
    public void verifyLogin() {
    }

    @Override
    public void viewProfile() {
    }

    
  


}
