package com.natours.natoursbackend.services;

import com.natours.natoursbackend.dto.LoginRequest;
import com.natours.natoursbackend.dto.LoginResponse;
import com.natours.natoursbackend.exceptions.UserAlreadyPresentException;
import com.natours.natoursbackend.dto.RegisterRequest;
import com.natours.natoursbackend.models.AppUser;
import com.natours.natoursbackend.repositories.UserRepository;
import com.natours.natoursbackend.utilities.JwtUtilities;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtilities jwtUtilities;

    public void register(RegisterRequest registerRequest) throws Exception {

        Optional<AppUser> appUserOptional = userRepository.findByEmail(registerRequest.getEmail());
        if(appUserOptional.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setName(registerRequest.getName());
            appUser.setEmail(registerRequest.getEmail());
            appUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            appUser.setCreatedDate(Instant.now());
            userRepository.save(appUser);
        }else{
            throw new UserAlreadyPresentException("User Is Already Present With The Given Email Address:- " + registerRequest.getEmail());
        }

    }

    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        String token = jwtUtilities.generateToken(userDetails);

        return LoginResponse.builder()
                .email(loginRequest.getEmail())
                .authenticationToken(token)
                .expiresAt(jwtUtilities.extractExpiration(token))
                .build();
    }
}
/*
{
    "email": "anjaniy01salekar@gmail.com",
    "authenticationToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmphbml5MDFzYWxla2FyQGdtYWlsLmNvbSIsImlhdCI6MTY1NzczNjkxOCwiZXhwIjoxNjU3NzM3NTE4fQ.bay52IbiP_NJ0lq4gLqz7lS0yPWXtQaVw0iYxfXojnc",
    "expiresAt": "2022-07-13T18:38:38.000+00:00"
}
 */
