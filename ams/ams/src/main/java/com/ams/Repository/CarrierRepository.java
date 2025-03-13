package com.ams.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.Model.Booking;
import com.ams.Model.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier, Integer> {

}
