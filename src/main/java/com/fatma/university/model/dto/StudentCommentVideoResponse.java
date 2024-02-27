package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentVideoResponse {

    @JsonProperty("studentComment_id")
    private long id;
    @JsonProperty("student_comment")
    private String comment;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("video_id")
    private long videoId;
    @JsonProperty("creation_date_time")
    private LocalDateTime creationDate;
}
