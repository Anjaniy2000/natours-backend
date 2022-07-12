package com.natours.natoursbackend.dto;

import lombok.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String email;
    private String authenticationToken;
    private Instant expiresAt;
}
