package com.ams.Controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.ams.Model.Customer;
import com.ams.Service.CustomerService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private final BCryptPasswordEncoder   passwordEncoder;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Initialize the password encoder
    }
    
    // Create a new customer
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("Controller addCustomer method called");
        // Directly call the service to handle registration logic
        Customer savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }


    // Get all customers
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return a 204 status if no customers are found
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);  // Return a 200 status with the list
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return a 404 status if customer is not found
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);  // Return a 200 status with the customer data
    }

    // Update customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        Optional<Customer> existingCustomer = customerService.getCustomerById(id);
        if (!existingCustomer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return a 404 status if customer not found
        }
        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);  // Return a 200 status with the updated customer
    }

    // Delete customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeCustomer(@PathVariable int id) {
        Optional<Customer> existingCustomer = customerService.getCustomerById(id);
        if (!existingCustomer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return a 404 status if customer not found
        }
        customerService.removeCustomer(id);
        return new ResponseEntity<>("Customer removed with id: " + id, HttpStatus.OK);  // Return a 200 status with a success message
    }
}
