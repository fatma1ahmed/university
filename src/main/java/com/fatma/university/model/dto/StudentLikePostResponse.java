package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentLikePostResponse {



    @JsonProperty("like_id")
    private long id;
    @JsonProperty("student_isLike")
    private boolean isLike;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("post_id")
    private long postId;

}
