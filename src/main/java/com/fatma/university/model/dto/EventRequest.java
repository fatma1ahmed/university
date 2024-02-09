package com.fatma.university.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.university.model.Enum.BroadCast;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    @NotNull(message = "please,Enter address")
    private String address;
    @NotNull(message = "please,Enter place")
    private String place;
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Invalid date format. Please use dd-MM-yyyy format.")
    private String date;
    @Pattern(regexp = "\\d{2}:\\d{2} (AM|PM)", message = "Time format should be HH:mm AM/PM")
    private String time;
    private BroadCast isBroadcast;
    private String linkPath;
    private String imagePath;
    @ManyToOne
    @JsonIgnore
    private Category category;
    private long categoryId;
}
