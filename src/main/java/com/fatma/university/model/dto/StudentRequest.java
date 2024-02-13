package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
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
public class StudentRequest {
    @NotNull(message = "please,Enter Your FullName")
    @JsonProperty("student_full_name")
    private String fullName;
    @NotNull(message = "please,Enter Your Email")
    @Email
    @Column(unique = true)
    @JsonProperty("student_email")
    private  String email;
    @NotNull(message = "please,Enter Your password")
    @Column(unique = true)
    @Size(min = 8,max = 18,message = "should enter your password between 8 and 18")
    @JsonProperty("student_password")
    private  String password;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ###-###-#### format.")
    @JsonProperty("student_phone")
    private  String phone;
    @JsonProperty("student_image_path")
    private  String imagePath;
}
