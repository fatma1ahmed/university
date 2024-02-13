package com.fatma.university.model.dto;

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
import org.springframework.context.event.EventListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    @JsonProperty("event_id")
    private long id;
    @JsonProperty("event_address")

    private String address;
    @JsonProperty("event_place")

    private String place;
    @JsonProperty("event_date")

    private String date;
    @JsonProperty("event_time")
    private String time;

    @JsonProperty("event_broadcast")
    private BroadCast isBroadcast;

    @JsonProperty("event_link_path")
    private String linkPath;

    @JsonProperty("event_image_path")
    private String imagePath;

    @JsonProperty("category_id")
    private long categoryId;

}