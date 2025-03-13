package com.ams.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ams.Model.Customer;
import com.ams.Repository.CustomerRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Create a new customer
    @Autowired
    private BCryptPasswordEncoder  passwordEncoder; 
   
    public Customer addCustomer(Customer customer) {
//        System.out.println("Register method called");
        if (customerRepository.findByUserName(customer.getUserName()) != null) {
            throw new RuntimeException("User already exists");
        }
        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        System.out.println("Hashed Password at Registration: " + hashedPassword);
        customer.setPassword(hashedPassword);
        return customerRepository.save(customer);
    }


    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById((long) id);
    }

    // Update customer by ID
    @Transactional
    public Customer updateCustomer(int id, Customer customerDetails){
        Optional<Customer> customer = customerRepository.findById((long) id);
        if (customer.isPresent()) {
            Customer existingCustomer = customer.get();
            // Update fields here
            existingCustomer.setUserName(customerDetails.getUserName());
            existingCustomer.setPassword(customerDetails.getPassword());
            // Update other fields...
            return customerRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    // Delete customer by ID
    public String removeCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById((long) id);
        if (customer.isPresent()) {
            customerRepository.deleteById((long) id);
            return "Customer removed with id: " + id;
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }
}
