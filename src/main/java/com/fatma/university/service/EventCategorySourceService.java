package com.fatma.university.service;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;

import java.io.IOException;

public interface EventCategorySourceService {
    public EventResponse assignEventToCategoryAndSource(EventRequest eventRequest) throws IOException;

    public EventResponse updateEvent(EventRequest eventRequest,long id) throws IOException;
}
