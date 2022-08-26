/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class Street {
    private int streetID;
    private String streetName;
    private City city;

    public int getStreetID() {
        return streetID;
    }

    public void setStreetID(int streetID) {
        this.streetID = streetID;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
}
