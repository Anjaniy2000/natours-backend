package com.natours.natoursbackend.services;

import com.natours.natoursbackend.exceptions.UserNotFoundException;
import com.natours.natoursbackend.models.AppUser;
import com.natours.natoursbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = userRepository.findByEmail(email);
        AppUser appUser = appUserOptional.orElseThrow(() -> new UserNotFoundException("User Not Found With The Given Email Address:- " + email));
        return new User(appUser.getEmail(), appUser.getPassword(), new ArrayList<>());
    }
}
/*
{
    "email": "anjaniy01salekar@gmail.com",
    "authenticationToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmphbml5MDFzYWxla2FyQGdtYWlsLmNvbSIsImlhdCI6MTY1NzczNTk3NiwiZXhwIjoxNjU3NzM2NTc2fQ.UX0pLj6_9_9NM3fNfAEXMiiXaA7uy7I6EBYnM_bt4Pg",
    "expiresAt": null
}
 */
