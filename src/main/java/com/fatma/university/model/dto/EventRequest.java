package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.Enum.BroadCast;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

    @JsonProperty("event_address")
    @NotNull(message = "please,Enter address")
    private String address;
    @JsonProperty("event_description")
    private String description;
    @JsonProperty("event_place")
    @NotNull(message = "please,Enter place")
    private String place;

    @JsonProperty("event_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime date;


    @JsonProperty("event_broadcast")
    private BroadCast isBroadcast;

    @JsonProperty("event_link_path")
    private String linkPath;

    @JsonProperty("event_image_path")
    private String imagePath;

    @JsonProperty("category_id")
    private long categoryId;

    @JsonProperty("source_id")
    private long sourceId;
}
