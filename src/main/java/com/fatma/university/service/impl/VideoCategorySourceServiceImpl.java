package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Source;
import com.fatma.university.model.entity.Video;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.VideoCategorySourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class VideoCategorySourceServiceImpl implements VideoCategorySourceService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SourceService sourceService;
    @Override
    public void assignVideoToCategoryAndSource(Video video, long categoryId, long sourceId) throws IOException {
        Category exisitCategory=categoryService.getById(categoryId);
        Source exisitSource=sourceService.getById(sourceId);
        video.setCategory(exisitCategory);
        video.setSource(exisitSource);
    }

    @Override
    public void updateVideo(Video video, long categoryId, long sourceId) throws IOException {
        Category exisitCategory=categoryService.getById(categoryId);
        Source exisitSource=sourceService.getById(sourceId);
        video.setCategory(exisitCategory);
        video.setSource(exisitSource);

    }
}
