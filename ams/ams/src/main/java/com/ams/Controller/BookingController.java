package com.ams.Controller;
import com.ams.Model.Booking;
import com.ams.Service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bookings")

public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get all bookings (GET)
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Create booking (POST)
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Get booking by ID (GET)
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    // Update booking (PUT)
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking bookingDetails) {
        return bookingService.updateBooking(id, bookingDetails);
    }

    // Delete booking (DELETE)
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
    
 // Get bookings by flight ID (GET)
    @GetMapping("/flight/{flightId}")
    public List<Booking> getBookingsByFlightId(@PathVariable int flightId) {
        return bookingService.getBookingsByFlightId(flightId);
    }
    
    

}
