package com.ams.Model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightID;

    @Column(name = "carrier_id", nullable = false)
    private int carrierID;

    @Column(name = "carrier_name", nullable = false)
    private String carrierName;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "air_fare", nullable = false)
    private int airFare;

    @Column(name = "seat_capacity_business_class", nullable = false)
    private int seatCapacityBusinessClass;

    @Column(name = "seat_capacity_economy_class", nullable = false)
    private int seatCapacityEconomyClass;

    @Column(name = "seat_capacity_executive_class", nullable = false)
    private int seatCapacityExecutiveClass;

    @Column(name = "date_of_journey", nullable = false)
    private LocalDate dateOfJourney;

    // Default constructor
    public Flight() {
    }

    // Constructor with fields
    public Flight(int carrierID, String carrierName, String origin, String destination, int airFare,
                  int seatCapacityBusinessClass, int seatCapacityEconomyClass, int seatCapacityExecutiveClass,
                  LocalDate dateOfJourney) {
        this.carrierID = carrierID;
        this.carrierName = carrierName;
        this.origin = origin;
        this.destination = destination;
        this.airFare = airFare;
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
        this.dateOfJourney = dateOfJourney;
    }

    // Getters and Setters
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public int getCarrierID() {
        return carrierID;
    }

    public void setCarrierID(int carrierID) {
        this.carrierID = carrierID;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAirFare() {
        return airFare;
    }

    public void setAirFare(int airFare) {
        this.airFare = airFare;
    }

    public int getSeatCapacityBusinessClass() {
        return seatCapacityBusinessClass;
    }

    public void setSeatCapacityBusinessClass(int seatCapacityBusinessClass) {
        this.seatCapacityBusinessClass = seatCapacityBusinessClass;
    }

    public int getSeatCapacityEconomyClass() {
        return seatCapacityEconomyClass;
    }

    public void setSeatCapacityEconomyClass(int seatCapacityEconomyClass) {
        this.seatCapacityEconomyClass = seatCapacityEconomyClass;
    }

    public int getSeatCapacityExecutiveClass() {
        return seatCapacityExecutiveClass;
    }

    public void setSeatCapacityExecutiveClass(int seatCapacityExecutiveClass) {
        this.seatCapacityExecutiveClass = seatCapacityExecutiveClass;
    }

    public LocalDate getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(LocalDate dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    @Override
    public String toString() {
        return "Flight [flightID=" + flightID + ", carrierID=" + carrierID + ", carrierName=" + carrierName
                + ", origin=" + origin + ", destination=" + destination + ", airFare=" + airFare
                + ", seatCapacityBusinessClass=" + seatCapacityBusinessClass + ", seatCapacityEconomyClass="
                + seatCapacityEconomyClass + ", seatCapacityExecutiveClass=" + seatCapacityExecutiveClass
                + ", dateOfJourney=" + dateOfJourney + "]";
    }
}
