package com.ams.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
