package com.natours.natoursbackend.dto;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUserDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private Instant createdDate; //User Creation Date
}

//What we'll get(Current User): id, name, email, password, createdDate

//View: name, email, createdDate

//Populate: name, email

//Update: id, name, email, password, createdDate
