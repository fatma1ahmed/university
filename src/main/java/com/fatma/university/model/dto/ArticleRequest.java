package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    @JsonProperty("article_address")
    private String address;
    @JsonProperty("article_image_path")
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String imagePath;
    @JsonProperty("source_id")
    private long sourceId;
}
