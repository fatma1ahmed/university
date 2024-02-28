package com.fatma.university.model.entity;

import com.fatma.university.model.Enum.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
    private NotificationType notificationType;
    private long studentId;
    private long postId;
    private long videoId;
    private long articleId;
    private long eventId;
}
