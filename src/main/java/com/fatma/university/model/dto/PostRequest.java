package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String content;
    private String imagePath;
    private long categoryId;
    private long sourceId;
    @ManyToOne
    @JsonIgnore
    private Category category;
    @ManyToOne
    @JsonIgnore
    private Source source;
}
