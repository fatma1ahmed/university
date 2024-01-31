package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotCorrectException;
import com.fatma.university.mapper.CategoryMapper;
import com.fatma.university.model.dto.CategoryRequest;
import com.fatma.university.model.dto.CategoryResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.reposity.CategoryRepo;
import com.fatma.university.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepo categoryRepo;
@Autowired
private CategoryMapper categoryMapper;

    @Override
    public CategoryResponse add(CategoryRequest categoryRequest) {
        return categoryMapper.fromEntityToResponseDto(categoryRepo.save(categoryMapper.toEntity(categoryRequest)));
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest,long id) {
        checkThisIsFoundORThrowException(id);
        Category category=categoryMapper.toEntity(categoryRequest);
        category.setId(id);
        return categoryMapper.fromEntityToResponseDto(categoryRepo.save(category));
    }

    @Override
    public Category getById(long id) {
        Category category=categoryRepo.findById(id).orElseThrow(
                ()->new RecordNotCorrectException("Category with " + id  +" not found")
        );
        return category;
    }



    @Override
    public List<CategoryResponse> getAll(){
        return categoryRepo.findAll().stream()
                .map(category -> categoryMapper.fromEntityToResponseDto(category))
                .toList();

    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        categoryRepo.deleteById(id);
      return new ResponseEntity<>("Category with " + id  +" is deleted",HttpStatus.ACCEPTED);
    }

    @Override
    public void checkThisIsFoundORThrowException(long id) {
        getById(id);
    }

}
