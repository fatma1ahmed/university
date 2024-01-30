package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.Enum.BroadCast;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private String address;
    private String place;
    private String date;
    private String time;
    private BroadCast isBroadcast;
    @ManyToOne
    @JsonIgnore
    private Category category;
    @ManyToOne
    @JsonIgnore
    private Source source;
    @JsonProperty("category-name")
    private String categoryName;
    @JsonProperty("source-name")
    private String sourceName;
}