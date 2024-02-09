package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCommentPostResponse {
    private long id;
    private String comment;
    @ManyToOne
    @JsonIgnore
    private Student student;
    @ManyToOne
    @JsonIgnore
    private Post post;
    private String studentName;
    private String postContent;
}
