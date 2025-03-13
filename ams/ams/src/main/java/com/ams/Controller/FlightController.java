package com.ams.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ams.Model.Flight;
import com.ams.Service.FlightService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    // Add new flight
    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    // Get all flights
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    // Get a flight by ID
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable int id) {
        return flightService.getFlightById(id);
    }

    // Update flight by ID
    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight flightDetails) {
        return flightService.updateFlight(id, flightDetails);
    }

    // Delete flight by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable int id) {
        return flightService.removeFlight(id);
    }
}