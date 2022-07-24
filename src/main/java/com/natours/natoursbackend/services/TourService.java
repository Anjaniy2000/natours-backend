package com.natours.natoursbackend.services;

import com.natours.natoursbackend.dto.TourDto;
import com.natours.natoursbackend.exceptions.TourNotFoundException;
import com.natours.natoursbackend.models.Tour;
import com.natours.natoursbackend.repositories.TourRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TourDto> getAllTours() {
        List<Tour> tours= tourRepository.findAll();
        return tours.stream().map(tour -> modelMapper.map(tour,TourDto.class)).collect(Collectors.toList());
    }

    public TourDto getTourById(String tourId) {
        Tour tour = tourRepository.findById(tourId).orElseThrow(() -> new TourNotFoundException("Tour Not Found!"));
        return modelMapper.map(tour, TourDto.class);
    }
}
