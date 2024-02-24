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
public class StudentComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
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

}
