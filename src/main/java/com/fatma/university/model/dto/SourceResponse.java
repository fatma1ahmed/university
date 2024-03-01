package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Person;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceResponse extends Person {
    @JsonProperty("source_id")
    private long id;
    @JsonProperty("department_id")
    private long departmentId;


}