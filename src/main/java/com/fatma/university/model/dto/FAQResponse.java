package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FAQResponse {

    private long id;

    @NotNull(message = "question can't be null")
    @NotEmpty(message = "question can't be empty")
    private String question;

    @NotNull(message = "answer can't be null")
    @NotEmpty(message = "answer can't be empty")
    private String answer;

    @JsonProperty("source_id")
    private long sourceId;


}
