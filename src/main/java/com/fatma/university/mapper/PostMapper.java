package com.fatma.university.mapper;

import com.fatma.university.model.dto.PostRequest;
import com.fatma.university.model.dto.PostResponse;
import com.fatma.university.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostRequest postRequest);

    @Mapping(target = "categoryId" , source = "post.category.id")
    @Mapping(target = "sourceId" , source = "post.source.id")
    PostResponse toResponse(Post post);
}
