package com.fatma.university.mapper;

import com.fatma.university.model.dto.VideoRequest;
import com.fatma.university.model.dto.VideoResponse;
import com.fatma.university.model.entity.Video;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VideoMapper {
    Video toEntity(VideoRequest videoRequest);
    @Mapping(target = "categoryId",source = "video.category.id")
    @Mapping(target = "sourceId",source = "video.source.id")
    VideoResponse toResponse(Video video);
}
