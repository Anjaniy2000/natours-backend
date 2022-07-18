package com.natours.natoursbackend.services;

import com.natours.natoursbackend.dto.LoginRequest;
import com.natours.natoursbackend.dto.LoginResponse;
import com.natours.natoursbackend.exceptions.UserAlreadyPresentException;
import com.natours.natoursbackend.dto.RegisterRequest;
import com.natours.natoursbackend.models.AppUser;
import com.natours.natoursbackend.repositories.AppUserRepository;
import com.natours.natoursbackend.security.JwtUtilities;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AppUserRepository appUserRepository;

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

        Optional<AppUser> appUserOptional = appUserRepository.findByEmail(registerRequest.getEmail());
        if(appUserOptional.isEmpty()){
            AppUser appUser = new AppUser();
            appUser.setName(registerRequest.getName());
            appUser.setEmail(registerRequest.getEmail());
            appUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            appUser.setCreatedDate(Instant.now());
            appUserRepository.save(appUser);
        }else{
            throw new UserAlreadyPresentException("User Is Already Present With The Given Email Address:- " + registerRequest.getEmail());
        }

    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtUtilities.generateToken(authenticate);
        return LoginResponse.builder()
                .authenticationToken(token)
                .expiresAt(Instant.now().plusMillis(jwtUtilities.getJwtExpirationInMillis()))
                .email(loginRequest.getEmail())
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
