package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentArticleResponse {

    @JsonProperty("student_comment_id")
    private long id;
    @JsonProperty("student_comment")
    private String comment;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("article_id")
    private long articleId;

    @JsonProperty("creation_date_time")
    private LocalDateTime creationDate;
}
