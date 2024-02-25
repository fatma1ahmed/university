package com.fatma.university.model.entity;

import com.fatma.university.model.Enum.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Message;
    @CreationTimestamp
    private LocalDateTime createNotification;
    @ManyToOne
    private Source source;
    private NotificationType notificationType;
    private long studentId;
    private long postId;
    private long videoId;
    private long articleId;
    private long eventId;
}
