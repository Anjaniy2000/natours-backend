package com.natours.natoursbackend.controllers;

import com.natours.natoursbackend.dto.LoginRequest;
import com.natours.natoursbackend.dto.AuthenticationResponse;
import com.natours.natoursbackend.dto.RefreshTokenRequest;
import com.natours.natoursbackend.dto.RegisterRequest;
import com.natours.natoursbackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/refresh/token")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public String logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        authService.logout(refreshTokenRequest.getRefreshToken());
        return "Logout Successfully";
    }

}
