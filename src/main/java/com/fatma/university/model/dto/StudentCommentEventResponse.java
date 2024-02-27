package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentEventResponse {


    @JsonProperty("studentComment_id")
    private long id;
    @JsonProperty("student_comment")
    private String comment;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("event_id")
    private long eventId;
    @JsonProperty("creation_date_time")
    private LocalDateTime creationDate;

}
