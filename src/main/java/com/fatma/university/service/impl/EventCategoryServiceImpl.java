package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.EventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventCategoryServiceImpl implements EventCategoryService {
    @Autowired
    private CategoryService categoryService;

    @Override
    public void assignEventToCategory(Event event, long CategoryId)   {
        Category existCategory=categoryService.getById(CategoryId);
        event.setCategory(existCategory);
    }


}
