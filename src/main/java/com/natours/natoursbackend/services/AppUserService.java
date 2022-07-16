package com.natours.natoursbackend.services;

import com.natours.natoursbackend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

}
