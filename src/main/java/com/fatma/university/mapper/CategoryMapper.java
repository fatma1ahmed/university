package com.fatma.university.mapper;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryRequest categoryRequest);

    CategoryResponse toResponse(Category entity);
}
