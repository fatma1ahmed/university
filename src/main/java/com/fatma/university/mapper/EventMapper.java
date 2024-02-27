package com.fatma.university.mapper;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventRequest eventRequest);
    @Mapping(target = "categoryId" , source = "event.category.id")
    @Mapping(target = "sourceId" , source = "event.source.id")
    EventResponse toResponse(Event event);
}
