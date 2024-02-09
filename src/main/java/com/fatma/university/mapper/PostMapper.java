package com.fatma.university.mapper;

import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.model.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostRequest postRequest);
    PostResponse fromEntityToResponseDto(Post entity);
}
