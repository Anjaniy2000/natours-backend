package com.natours.natoursbackend.services;

import com.natours.natoursbackend.dto.AppUserDto;
import com.natours.natoursbackend.dto.PasswdDto;
import com.natours.natoursbackend.exceptions.PasswordExceptions;
import com.natours.natoursbackend.exceptions.UserNotFoundException;
import com.natours.natoursbackend.models.AppUser;
import com.natours.natoursbackend.repositories.AppUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired 
    private AppUserRepository appUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUserDto getCurrentUser() {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User Not Found With The Given Email Address:- " + user.getUsername()));

        return modelMapper.map(appUser, AppUserDto.class);
    }


    public void update(AppUserDto appUserDto) {
        appUserRepository.save(modelMapper.map(appUserDto,AppUser.class));
    }

    public void delete(String id) {
        appUserRepository.deleteById(id);
    }

    public void changePwd(PasswdDto passwdDto) {
        AppUser appUser=modelMapper.map(getCurrentUser(),AppUser.class );
        if(passwordEncoder.matches(passwdDto.getOldPasswd(), appUser.getPassword()))
        {
            appUser.setPassword(passwordEncoder.encode(passwdDto.getNewPasswd()));
            appUserRepository.save(appUser);
        }
        else{
         throw new PasswordExceptions("Ols password is incorrect");
        }

    }
}
