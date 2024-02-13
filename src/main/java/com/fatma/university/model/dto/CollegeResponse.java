package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeResponse {
    @JsonProperty("college_id")
    private long id;
    @JsonProperty("college_name")
    private String name;
    @JsonProperty("college_icon")
    private String icon;
}
