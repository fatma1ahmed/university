package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeRequest {

    @NotNull(message = "please,Enter college_name")
    @JsonProperty("college_name")
    private String name;
    @JsonProperty("college_icon")
    private String icon;
}
