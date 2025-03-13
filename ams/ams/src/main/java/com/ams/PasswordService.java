package com.ams;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordService {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean verifyPassword(String providedPassword, String storedEncodedPassword) {
        System.out.println("Stored Password: " + storedEncodedPassword);
        System.out.println("Provided Password: " + providedPassword);

        boolean isMatch = passwordEncoder.matches(providedPassword, storedEncodedPassword);
        System.out.println("Password Match: " + isMatch);
        return isMatch;
    }
}
