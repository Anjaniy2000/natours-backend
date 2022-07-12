package com.natours.natoursbackend.controllers;

import com.natours.natoursbackend.dto.RegisterRequest;
import com.natours.natoursbackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody RegisterRequest registerRequest) throws Exception {
        authService.register(registerRequest);
        return "User Registration Successful";
    }
}
