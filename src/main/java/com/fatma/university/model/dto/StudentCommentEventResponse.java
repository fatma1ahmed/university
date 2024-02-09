package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentEventResponse {
    private long id;
    private String comment;
    @ManyToOne
    @JsonIgnore
    private Student student;
    @ManyToOne
    @JsonIgnore
    private Event event;
    private String studentName;
    private String eventAddress;
}
