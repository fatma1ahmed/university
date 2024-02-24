package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceRequest {
    @NotNull(message = "please,Enter Your FullName")
    private String fullName;
    @NotNull(message = "please,Enter Your Email")
    @Email(message = "This is Email, you should be more smart.")
    private String email;
    @NotNull(message = "please,Enter Your password")
    @Column(unique = true)
    @Size(min = 8, max = 18, message = "should enter your password between 8 and 18")
    private String password;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ###-###-#### format.")
    private String phone;
    private String imagePath;
    private long departmentId;
}