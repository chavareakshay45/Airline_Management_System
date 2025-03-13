package com.ams.Model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "flight_id", nullable = false)
    private int flightId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "seat_category", nullable = false)
    private String seatCategory;

    @Column(name = "date_of_travel", nullable = false)
    private LocalDate dateOfTravel;

    @Column(name = "booking_status", nullable = false)
    private String bookingStatus;

    @Column(name = "booking_amount", nullable = false)
    private int bookingAmount;

    public Booking() {
    }

    public Booking(int bookingId, String customerName, int flightId, String seatNumber, String seatCategory,
                   LocalDate dateOfTravel, String bookingStatus, int bookingAmount) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.seatCategory = seatCategory;
        this.dateOfTravel = dateOfTravel;
        this.bookingStatus = bookingStatus;
        this.bookingAmount = bookingAmount;
    }

    // Getters and Setters

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
