package com.natours.natoursbackend.repositories;

import com.natours.natoursbackend.models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser,String> {

    Optional<AppUser> findByEmail(String email);

}
