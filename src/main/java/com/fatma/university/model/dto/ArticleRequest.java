package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    private String address;
    private String imagePath;
    @ManyToOne
    @JsonIgnore
    private Source source;
    private long sourceId;
}
