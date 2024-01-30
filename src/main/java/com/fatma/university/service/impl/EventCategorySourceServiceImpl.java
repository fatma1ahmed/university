package com.fatma.university.service.impl;

import com.fatma.university.mapper.EventMapper;
import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.EventCategorySourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EventCategorySourceServiceImpl implements EventCategorySourceService {
    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private SourceServiceImpl sourceService;
    @Autowired
    private EventMapper eventMapper;
    @Override
    public EventResponse assignEventToCategoryAndSource(EventRequest eventRequest) throws IOException {
        Category existCategory=categoryService.getById(eventRequest.getCategoryId());
        Source existSource=sourceService.getById(eventRequest.getSourceId());
        Event event=eventMapper.toEntity(eventRequest);
        event.setCategory(existCategory);
        event.setSource(existSource);
        EventResponse eventResponse=new EventResponse();
        eventResponse.setCategoryName(existCategory.getCategoryName());
        eventResponse.setSourceName(existSource.getFullName());
        eventResponse.setAddress(event.getAddress());
        eventResponse.setPlace(event.getPlace());
        eventResponse.setDate(event.getDate());
        eventResponse.setTime(event.getTime());
        eventResponse.setIsBroadcast(event.getIsBroadcast());
        eventService.add(event);
        return eventResponse;
    }

    @Override
    public EventResponse updateEvent(EventRequest eventRequest, long id) throws IOException {
        Category existCategory = categoryService.getById(eventRequest.getCategoryId());
        Source existSource = sourceService.getById(eventRequest.getSourceId());
        Event existEvent = eventService.getById(id);
        Event event = eventMapper.toEntity(eventRequest);
        event.setSource(existSource);
        event.setCategory(existCategory);
        event.setId(existEvent.getId());
        eventService.update(event, id);
        EventResponse eventResponse=new EventResponse();
        eventResponse.setCategoryName(existCategory.getCategoryName());
        eventResponse.setSourceName(existSource.getFullName());
        eventResponse.setAddress(event.getAddress());
        eventResponse.setPlace(event.getPlace());
        eventResponse.setDate(event.getDate());
        eventResponse.setTime(event.getTime());
        eventResponse.setIsBroadcast(event.getIsBroadcast());
        eventService.add(event);
        return eventResponse;


    }
}
