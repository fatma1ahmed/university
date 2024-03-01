package com.fatma.university.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
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
public class Video {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String title;
//    @Column(columnDefinition = "LONGTEXT")
    @Lob
    private String videoPath;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Source source;
    @OneToMany(mappedBy = "video",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentComment> studentComments;
    @OneToMany(mappedBy = "video",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentLike> studentLikes;


}
