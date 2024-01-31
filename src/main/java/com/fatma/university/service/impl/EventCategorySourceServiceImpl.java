package com.fatma.university.service.impl;

import com.fatma.university.mapper.EventMapper;
import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.CategoryService;
import com.fatma.university.service.EventCategorySourceService;
import com.fatma.university.service.EventService;
import com.fatma.university.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EventCategorySourceServiceImpl implements EventCategorySourceService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SourceService sourceService;
    @Override
    public void assignEventToCategoryAndSource(Event event, long CategoryId,long sourceId) throws IOException {
        Category existCategory=categoryService.getById(CategoryId);
        Source existSource=sourceService.getById(sourceId);
        event.setCategory(existCategory);
        event.setSource(existSource);


    }

    @Override
    public void updateEvent(Event event,long CategoryId,long sourceId) throws IOException {
        Category existCategory = categoryService.getById(CategoryId);
        Source existSource = sourceService.getById(sourceId);
        event.setSource(existSource);
        event.setCategory(existCategory);




    }

}
