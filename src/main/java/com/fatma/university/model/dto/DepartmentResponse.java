package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.College;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {

    @JsonProperty("department_id")
    private long id;

    @JsonProperty("department_name")
    private String name;

    @JsonProperty("department_details")
    private String details;

    @JsonProperty("college_id")
    private long collegeId;
}
