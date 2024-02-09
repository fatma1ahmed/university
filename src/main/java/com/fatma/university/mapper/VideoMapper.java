package com.fatma.university.mapper;

import com.fatma.university.model.dto.VideoRequest;
import com.fatma.university.model.dto.VideoResponse;
import com.fatma.university.model.entity.Video;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VideoMapper {
    Video toEntity(VideoRequest videoRequest);
    VideoResponse fromEntityToResponseDto(Video entity);
}
