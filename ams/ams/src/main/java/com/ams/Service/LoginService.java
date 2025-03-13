package com.ams.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ams.Model.Customer;
import com.ams.Repository.CustomerRepository;

@Service
public class LoginService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticate(String userName, String providedPassword) {
        // Fetch the user from the database
        Customer customer = customerRepository.findByUserName(userName);

        if (customer != null) {
            // Compare the provided password with the hashed password
            boolean isMatch = passwordEncoder.matches(providedPassword, customer.getPassword());
            System.out.println("Stored Password: " + customer.getPassword());
            System.out.println("Provided Password: " + providedPassword);
            System.out.println("Password Match: " + isMatch);
            return isMatch;
        }

        return false; // User not found or password mismatch
    }
}
