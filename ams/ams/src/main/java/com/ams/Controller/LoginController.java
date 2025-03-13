package com.ams.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ams.Model.LoginRequest;
import com.ams.Model.ResponseMessage;
import com.ams.Service.LoginService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        // Authenticate the user using the login service
        boolean isAuthenticated = loginService.authenticate(loginRequest.getUserName(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok(new ResponseMessage("Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseMessage("Invalid username or password"));
        }
    }
}
