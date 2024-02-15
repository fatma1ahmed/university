package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentLikeEventResponse {

    @JsonProperty("is_like")
    private boolean isLike;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("event_id")
    private long eventId;
    @JsonProperty("post_id")
    private long  postId;
}
