package com.natours.natoursbackend.repositories;

import com.natours.natoursbackend.models.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TourRepository extends MongoRepository <Tour,String>{
}
