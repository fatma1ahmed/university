package com.fatma.university.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean isLike;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Event event;
    @ManyToOne
    private Video video;
    @ManyToOne
    private Article article;
    @OneToOne
    private Notification notification;
}
