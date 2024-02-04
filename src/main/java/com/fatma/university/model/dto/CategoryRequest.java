package com.fatma.university.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    @NotNull(message = "please,Enter categoryName")
    private String name;
    @Size(min = 5, max = 25, message = "enter your description between 5 and 25 character")
    private String description;
}