package com.fatma.university.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "please,Enter address")
    @NotNull(message = "please,Enter Your FullName")
    @JsonProperty("student_full_name")
    private String fullName;
    @NotNull(message = "please,Enter Your Email")
    @Email(message = "This is Email, you should be more smart.")
    @JsonProperty("student_email")
    private  String email;

    @NotNull(message = "please,Enter Your password")
    @Size(min = 8,max = 18,message = "should enter your password between 8 and 18")
    @Column(unique = true)
    @JsonProperty("student_password")
    private  String password;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ###-###-#### format.")
    @JsonProperty("student_phone")
    private  String phone;

    @JsonProperty("student_image_path")
//    @Column(columnDefinition = "LONGTEXT")
    @Lob
    private  String imagePath;
}
