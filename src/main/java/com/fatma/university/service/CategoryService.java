package com.fatma.university.service;

import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends CrudService<Category, CategoryRequest, CategoryResponse> {

}
