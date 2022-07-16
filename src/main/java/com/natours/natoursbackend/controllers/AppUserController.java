package com.natours.natoursbackend.controllers;

import com.natours.natoursbackend.dto.AppUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class AppUserController {

    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public AppUserDto view(){
        return null;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AppUserDto update(@RequestBody AppUserDto appUserDto){
        return null;
    }
     @DeleteMapping("/delete/{id}")
     @ResponseStatus(HttpStatus.OK)
     public String delete(@PathVariable("id") String id){
        return "User deleted Successfully";
     }
}
