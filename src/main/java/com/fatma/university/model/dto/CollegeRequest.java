package com.fatma.university.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeRequest {
    @NotNull(message = "please,Enter collegeName")
    private String collegeName;
}
