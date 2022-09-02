/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.model;

/**
 *
 * @author Sumaiya
 */
public class Booking {
    private int bookingID;
    private int priceInLKR;
    private String bookingStatus;
    private String bookingDateTime;
    private String feedback;
    private String ifAcceptedByDriver;
    private Customer customer;
    private Driver driver;
    private Vehicle vehicle;
    private BookingLocation bookingLocations;

    public Booking(int bookingID, int priceInLKR, String bookingStatus, String bookingDateTime, String feedback, String ifAcceptedByDriver, Customer customer, Driver driver, Vehicle vehicle, BookingLocation bookingLocations) {
        this.bookingID = bookingID;
        this.priceInLKR = priceInLKR;
        this.bookingStatus = bookingStatus;
        this.bookingDateTime = bookingDateTime;
        this.feedback = feedback;
        this.ifAcceptedByDriver = ifAcceptedByDriver;
        this.customer = customer;
        this.driver = driver;
        this.vehicle = vehicle;
        this.bookingLocations = bookingLocations;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getPriceInLKR() {
        return priceInLKR;
    }

    public void setPriceInLKR(int priceInLKR) {
        this.priceInLKR = priceInLKR;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(String bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getIfAcceptedByDriver() {
        return ifAcceptedByDriver;
    }

    public void setIfAcceptedByDriver(String ifAcceptedByDriver) {
        this.ifAcceptedByDriver = ifAcceptedByDriver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BookingLocation getBookingLocations() {
        return bookingLocations;
    }

    public void setBookingLocations(BookingLocation bookingLocations) {
        this.bookingLocations = bookingLocations;
    }
    
}
