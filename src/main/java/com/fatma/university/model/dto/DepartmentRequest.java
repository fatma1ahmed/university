package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.entity.College;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull(message = "please,Enter departmentName")
    private String name;
    @Size(min = 5, max = 25, message = "enter your details between 5 and 25 character")
    private String details;
    @ManyToOne
    @JsonIgnore
    private College college;
    private long collegeId;
}