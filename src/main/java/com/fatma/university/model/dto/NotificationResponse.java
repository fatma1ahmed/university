package com.fatma.university.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.Enum.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationResponse {


    @JsonProperty("notification_id")
    private long id;
    @JsonProperty("notification_message")
    private String message;
    @JsonProperty("notification_date")
    private LocalDateTime creationDate;
    @JsonProperty("source_id")
    private long sourceId;
    @JsonProperty("notification_type")
    private NotificationType notificationType;
    @JsonProperty("student_id")
    private long studentId;
    @JsonProperty("post_id")
    private long postId;
    @JsonProperty("video_id")
    private long videoId;
    @JsonProperty("article_id")
    private long articleId;
    @JsonProperty("event_id")
    private long eventId;

}
