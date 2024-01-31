package com.fatma.university.service;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public interface EventCategorySourceService {
    public void assignEventToCategoryAndSource(Event event,long categoryId,long sourceId) throws IOException;

    public void updateEvent(Event event,long CategoryId,long sourceId) throws IOException;
}
