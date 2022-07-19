package com.natours.natoursbackend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasswordDto {
    private String oldPassword;
    private String newPassword;
}
