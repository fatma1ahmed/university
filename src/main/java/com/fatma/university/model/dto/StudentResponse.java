package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {




    @JsonProperty("student_id")
    private long id;
    @JsonProperty("student_full_name")
    private String fullName;
    @JsonProperty("student_email")
    private  String email;
}
