package com.natours.natoursbackend.dto;

import lombok.*;
import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private String email;
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
}
