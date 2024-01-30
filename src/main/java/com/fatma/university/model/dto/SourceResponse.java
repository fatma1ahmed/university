package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.Department;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceResponse {
    @JsonProperty("full-name")
    private String fullName;
    private  String email;
    @ManyToOne
    @JsonIgnore
    private Department department;
    @JsonProperty("department-name")
    private String departmentName;

}