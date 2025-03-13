package com.ams.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ams.Exceptions.CarrierNotFoundException;
import com.ams.Model.Carrier;
import com.ams.Repository.CarrierRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;

    // Create or Update Carrier
    public Carrier addOrUpdateCarrier(Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    // Get All Carriers
    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    // Get Carrier by ID
    public Carrier getCarrierById(int carrierId) throws CarrierNotFoundException {
        Optional<Carrier> carrier = carrierRepository.findById(carrierId);
        if (carrier.isPresent()) {
            return carrier.get();
        } else {
            throw new CarrierNotFoundException("Carrier not found with ID: " + carrierId);
        }
    }

    // Delete Carrier by ID
   
    public ResponseEntity<String> deleteCarrier(int carrierId) throws CarrierNotFoundException {
        Optional<Carrier> carrier = carrierRepository.findById(carrierId);
        if (carrier.isPresent()) {
            carrierRepository.delete(carrier.get());
            return ResponseEntity.ok("Carrier with ID " + carrierId + " was successfully deleted");
        } else {
            throw new CarrierNotFoundException("Carrier not found with ID: " + carrierId);
        }
    }

}


   
