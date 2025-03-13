package com.ams.Controller;
import com.ams.Model.Carrier;
import com.ams.Service.CarrierService;
import com.ams.Exceptions.CarrierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/carrier")
public class CarrierController {

    @Autowired
    private CarrierService carrierService;

    // Get all carriers
    @GetMapping()
    public List<Carrier> getAllCarriers() {
        return carrierService.getAllCarriers();
    }

    // Get carrier by ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable("id") int id) {
        try {
            Carrier carrier = carrierService.getCarrierById(id);
            return ResponseEntity.ok(carrier);
        } catch (CarrierNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Add or update carrier
    @PostMapping
    public ResponseEntity<Carrier> addCarrier(@RequestBody Carrier carrier) {
        Carrier savedCarrier = carrierService.addOrUpdateCarrier(carrier);
        return ResponseEntity.ok(savedCarrier);
    }

    // Update carrier details
    @PutMapping("/{id}")
    public ResponseEntity<Carrier> updateCarrier(@PathVariable("id") int id, @RequestBody Carrier carrier) {
        try {
            carrier.setCarrierID(id);
            Carrier updatedCarrier = carrierService.addOrUpdateCarrier(carrier);
            return ResponseEntity.ok(updatedCarrier);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete carrier by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarrier(@PathVariable("id") int carrierId) {
        try {
            carrierService.deleteCarrier(carrierId);
            return ResponseEntity.ok("Carrier with ID " + carrierId + " was successfully deleted");
        } catch (CarrierNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrier not found with ID: " + carrierId);
        }
    }


}
