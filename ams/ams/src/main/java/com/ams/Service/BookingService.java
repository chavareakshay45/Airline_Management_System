package com.ams.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ams.Exceptions.BookingNotFoundException;
import com.ams.Model.Booking;
import com.ams.Repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create operation (POST)
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Get all bookings (GET)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get single booking by ID (GET)
    public Booking getBookingById(int bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new BookingNotFoundException("Booking with ID: " + bookingId + " does not exist.");
        }
    }

    // Update booking by ID (PUT)
    public Booking updateBooking(int bookingId, Booking bookingDetails) {
        Optional<Booking> existingBooking = bookingRepository.findById(bookingId);
        if (existingBooking.isPresent()) {
            Booking bookingToUpdate = existingBooking.get();
            
            // Update fields
            bookingToUpdate.setCustomerName(bookingDetails.getCustomerName());
            bookingToUpdate.setFlightId(bookingDetails.getFlightId());
            bookingToUpdate.setSeatNumber(bookingDetails.getSeatNumber());
            bookingToUpdate.setSeatCategory(bookingDetails.getSeatCategory());
            bookingToUpdate.setDateOfTravel(bookingDetails.getDateOfTravel());
            bookingToUpdate.setBookingStatus(bookingDetails.getBookingStatus());
            bookingToUpdate.setBookingAmount(bookingDetails.getBookingAmount());
            
            // Save and return updated booking
            return bookingRepository.save(bookingToUpdate);
        } else {
            throw new BookingNotFoundException("Booking with ID: " + bookingId + " does not exist.");
        }
    }

    // Delete booking by ID (DELETE)
    public void deleteBooking(int bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            bookingRepository.deleteById(bookingId);
        } else {
            throw new BookingNotFoundException("Booking with ID: " + bookingId + " does not exist.");
        }
    }
    
    public List<Booking> getBookingsByFlightId(int flightId) {
        return bookingRepository.findByFlightId(flightId); // No cast needed
    }

    // Get bookings by customerName
    public List<Booking> getBookingsByCustomerName(String customerName) {
        return bookingRepository.findByCustomerName(customerName); // No cast needed
    }

}
