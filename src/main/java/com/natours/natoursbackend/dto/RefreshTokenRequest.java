package com.natours.natoursbackend.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefreshTokenRequest {
    private String email;
    @NotBlank
    private String refreshToken;
}
