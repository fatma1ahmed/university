package com.fatma.university.service;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventService extends CrudService<Event, EventRequest, EventResponse> {
}
