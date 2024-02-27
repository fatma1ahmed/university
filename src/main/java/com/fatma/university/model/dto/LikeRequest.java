package com.fatma.university.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fatma.university.model.Enum.ChannelType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequest {

    @JsonProperty("student_id")
    @NotNull(message = "student_id can't be null")
    private long studentId;
    @JsonProperty("channel_id")
    @NotNull(message = "channel_id can't be null")
    private long channelId;
    @JsonProperty("channel_type")
    @NotNull(message = "channel_type can't be null")
    private ChannelType channelType;

}
