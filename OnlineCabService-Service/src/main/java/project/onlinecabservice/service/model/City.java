/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class City {
    private int cityID;
    private String cityName;
    private String cityEmail;
    private int cityPhoneNumber;

    public City(String cityName, String cityEmail, int cityPhoneNumber) {
        this.cityName = cityName;
        this.cityEmail = cityEmail;
        this.cityPhoneNumber = cityPhoneNumber;
    }
    
 
    public City(int cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public City(int cityID, String cityName, String cityEmail, int cityPhoneNumber) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.cityEmail = cityEmail;
        this.cityPhoneNumber = cityPhoneNumber;
    }



    public City(int cityID) {
        this.cityID = cityID;
    }

    
   
    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityEmail() {
        return cityEmail;
    }

    public void setCityEmail(String cityEmail) {
        this.cityEmail = cityEmail;
    }

    public int getCityPhoneNumber() {
        return cityPhoneNumber;
    }

    public void setCityPhoneNumber(int cityPhoneNumber) {
        this.cityPhoneNumber = cityPhoneNumber;
    }
    
}
