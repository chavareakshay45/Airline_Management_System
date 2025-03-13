package com.ams.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ams.Exceptions.FlightAlreadyPresentExceptions;
import com.ams.Exceptions.FlightNotFoundException;
import com.ams.Model.Flight;
import com.ams.Repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create operation (POST): Adds a new flight
    public ResponseEntity<Flight> addFlight(Flight flight) {
        Optional<Flight> existingFlight = flightRepository.findById(flight.getFlightID());
        if (existingFlight.isPresent()) {
            throw new FlightAlreadyPresentExceptions("Flight with ID: " + flight.getFlightID() + " already exists.");
        }
        Flight savedFlight = flightRepository.save(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED); // HTTP 201 Created
    }

    // Retrieve all flights (GET)
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Retrieve a single flight by ID (GET)
    public Flight getFlightById(int id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + id + " not found."));
    }

    // Update operation (PUT): Updates a flight by ID
    public Flight updateFlight(int id, Flight flightDetails) {
        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID " + id + " not found."));

        // Update the flight fields
        existingFlight.setCarrierID(flightDetails.getCarrierID());
        existingFlight.setCarrierName(flightDetails.getCarrierName());
        existingFlight.setOrigin(flightDetails.getOrigin());
        existingFlight.setDestination(flightDetails.getDestination());
        existingFlight.setAirFare(flightDetails.getAirFare());
        existingFlight.setSeatCapacityBusinessClass(flightDetails.getSeatCapacityBusinessClass());
        existingFlight.setSeatCapacityEconomyClass(flightDetails.getSeatCapacityEconomyClass());
        existingFlight.setSeatCapacityExecutiveClass(flightDetails.getSeatCapacityExecutiveClass());
        existingFlight.setDateOfJourney(flightDetails.getDateOfJourney());

        return flightRepository.save(existingFlight);
    }

    // Delete operation (DELETE): Deletes a flight by ID
    public ResponseEntity<String> removeFlight(int flightID) {
        Flight flight = flightRepository.findById(flightID)
                .orElseThrow(() -> new FlightNotFoundException("Flight with ID: " + flightID + " does not exist."));

        flightRepository.delete(flight);
        return new ResponseEntity<>("Flight removed successfully!", HttpStatus.OK); // HTTP 200 OK
    }
}
