package com.natours.natoursbackend.controllers;

import com.natours.natoursbackend.dto.AppUserDto;
import com.natours.natoursbackend.dto.PasswordDto;
import com.natours.natoursbackend.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public AppUserDto view(){
        return appUserService.getCurrentUser();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody AppUserDto appUserDto){
        appUserService.update(appUserDto);
        return "User Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") String id){
        appUserService.delete(id);
        return "User Deleted Successfully";
    }

    @PostMapping("/changePwd")
    @ResponseStatus(HttpStatus.OK)
    public String changePwd(@RequestBody PasswordDto passwordDto){
        appUserService.changePwd(passwordDto);
        return "Password Changed Successfully";
    }
}
