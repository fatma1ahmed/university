package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FAQRequest {


    @NotNull(message = "question can't be null")
    @NotEmpty(message = "question can't be empty")
    private String question;

    @NotNull(message = "answer can't be null")
    @NotEmpty(message = "answer can't be empty")
    private String answer;

    @JsonProperty("source_id")
    private long sourceId;



}
