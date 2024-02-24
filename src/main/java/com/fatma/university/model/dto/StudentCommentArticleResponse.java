package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentArticleResponse {

    @JsonProperty("studentComment_id")
    private long id;
    @JsonProperty("student_comment")
    private String comment;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("article_id")
    private long articleId;
}
