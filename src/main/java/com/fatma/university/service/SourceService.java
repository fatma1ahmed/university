package com.fatma.university.service;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SourceService extends CrudService<Source, SourceRequest, SourceResponse> {
    public List<Event> getEventsBySourceId(long sourceId);
}
