package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    @JsonProperty("category_id")
    private long id;
    @JsonProperty("category_name")
    private String name;
    @JsonProperty("category_description")
    private String description;
}
