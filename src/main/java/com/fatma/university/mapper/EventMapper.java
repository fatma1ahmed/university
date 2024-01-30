package com.fatma.university.mapper;

import com.fatma.university.model.dto.EventRequest;
import com.fatma.university.model.dto.EventResponse;
import com.fatma.university.model.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventRequest eventRequest);
    EventResponse fromEntityToResponseDto(Event entity);
}
