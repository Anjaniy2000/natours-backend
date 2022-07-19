package com.natours.natoursbackend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasswdDto {
    private String oldPasswd;
    private String newPasswd;
}
