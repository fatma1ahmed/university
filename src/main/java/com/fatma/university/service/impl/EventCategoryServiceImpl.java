package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.EventCategoryService;
import com.fatma.university.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EventCategoryServiceImpl implements EventCategoryService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SourceService sourceService;
    @Override
    public void assignEventToCategory(Event event, long CategoryId) throws IOException {
        Category existCategory=categoryService.getById(CategoryId);
        event.setCategory(existCategory);


    }

    @Override
    public void updateEvent(Event event,long CategoryId) throws IOException {
        Category existCategory = categoryService.getById(CategoryId);
        event.setCategory(existCategory);




    }

}
