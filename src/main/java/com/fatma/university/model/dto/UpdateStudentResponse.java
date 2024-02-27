package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentResponse {
    @JsonProperty("student_id")
    private long id;
    @JsonProperty("student_full_name")
    private String fullName;
    @JsonProperty("student_email")
    private  String email;
    @JsonProperty("student_brand")
    private String brand;
    @JsonProperty("student_academic_category")
    private String category;
    @JsonProperty("college_id")
    private long collegeId;
    @JsonProperty("department_id")
    private long departmentId;
}
