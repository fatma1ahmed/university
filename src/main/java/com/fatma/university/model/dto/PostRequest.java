package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
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
    @JsonProperty("post_content")
    private String content;
    @JsonProperty("post_image_path")
    @Lob
    private String imagePath;
    @JsonProperty("category_id")
    private long categoryId;
    @JsonProperty("source_id")
    private long sourceId;

}
