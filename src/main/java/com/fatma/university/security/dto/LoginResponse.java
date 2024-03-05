package com.fatma.university.security.dto;

import com.fatma.university.model.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponse {

    private long id;
    private String email;
    private UserRole userRole;
}
