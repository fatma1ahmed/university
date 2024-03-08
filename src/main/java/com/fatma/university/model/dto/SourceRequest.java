package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
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
    @JsonProperty("source_full_name")
    private String fullName;
    @NotNull(message = "please,Enter Your Email")
    @Email(message = "This is Email, you should be more smart.")
    @JsonProperty("source_email")
    private String email;
    @NotNull(message = "please,Enter Your password")
    @Column(unique = true)
    @Size(min = 8, max = 18, message = "should enter your password between 8 and 18")
    @JsonProperty("source_password")
    private String password;
    @Pattern(regexp = "\\d{4}-\\d{3}-\\d{4}", message = "Invalid phone number format. Please use ###-###-#### format.")
    @JsonProperty("source_phone")
    private String phone;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("source_image_path")
    private String imagePath;
    @JsonProperty("source_department_id")
    private long departmentId;
}