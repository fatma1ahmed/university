package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.Enum.BroadCast;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private String place;
    private LocalDateTime date;
    private BroadCast isBroadcast;
    private String linkPath;
    private String imagePath;
    @ManyToOne
    private Source source;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentComment> studentComments;
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentLike> studentLikes;
}