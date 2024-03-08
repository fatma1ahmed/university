package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String imagePath;
    private String content;
    private String sourceString;
    @ManyToOne
    private Source source;
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private List<StudentComment> studentComments;
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentLike> studentLikes;
}
