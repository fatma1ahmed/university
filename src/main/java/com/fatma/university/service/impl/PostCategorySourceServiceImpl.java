package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.PostCategorySourceService;
import com.fatma.university.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PostCategorySourceServiceImpl implements PostCategorySourceService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SourceService sourceService;
    @Override
    public void assignPostToCategoryAndSource(Post post, long categoryId, long sourceId) throws IOException {
        Category exisitCategory=categoryService.getById(categoryId);
        Source exisitSource=sourceService.getById(sourceId);
        post.setCategory(exisitCategory);
        post.setSource(exisitSource);
    }

    @Override
    public void updatePost(Post post, long categoryId, long sourceId) throws IOException {
        Category exisitCategory=categoryService.getById(categoryId);
        Source exisitSource=sourceService.getById(sourceId);
        post.setCategory(exisitCategory);
        post.setSource(exisitSource);
    }
}
