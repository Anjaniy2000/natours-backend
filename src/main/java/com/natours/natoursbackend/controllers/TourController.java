package com.natours.natoursbackend.controllers;

import com.natours.natoursbackend.dto.TourDto;
import com.natours.natoursbackend.services.TourService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourController {

    @Autowired
    private TourService tourService;


    @GetMapping("/getAllTours")
    @ResponseStatus(HttpStatus.OK)
    public List<TourDto> getAllTours(){
        return tourService.getAllTours();
    }

    @GetMapping("/getTourById/{tourId}")
    @ResponseStatus(HttpStatus.OK)
    public TourDto getTourById(@PathVariable("tourId") String tourId){
        return tourService.getTourById(tourId);
    }
}
