package com.ams.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ams.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByFlightId(int flightId);
    List<Booking> findByCustomerName(String customerName);
}
