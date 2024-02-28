package com.fatma.university.service;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Category;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService extends CrudService<Event, EventRequest, EventResponse> {


    List<EventResponse> getAllForDepartment(long departmentId);
}
