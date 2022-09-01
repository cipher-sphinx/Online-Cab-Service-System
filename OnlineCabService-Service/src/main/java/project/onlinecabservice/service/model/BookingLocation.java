/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class BookingLocation {
    private int bookingLocationID;
    private Street source;
    private Street destination;
    private int distanceInKm;

    public int getBookingLocationID() {
        return bookingLocationID;
    }

    public void setBookingLocationID(int bookingLocationID) {
        this.bookingLocationID = bookingLocationID;
    }

    public Street getSource() {
        return source;
    }

    public void setSource(Street source) {
        this.source = source;
    }

    public Street getDestination() {
        return destination;
    }

    public void setDestination(Street destination) {
        this.destination = destination;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
    
}
