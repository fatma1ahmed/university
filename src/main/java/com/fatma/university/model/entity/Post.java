package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @Lob
    private String imagePath;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Source source;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentComment> studentComments;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentLike> studentLikes;

    private String sourceString;


}
