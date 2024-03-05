package com.fatma.university.security;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePasswordDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String otp;
}
