package com.fatma.university.mapper;


import com.fatma.university.model.dto.NotificationResponse;
import com.fatma.university.model.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    @Mapping(target = "sourceId", source = "notification.source.id")
    NotificationResponse toResponse(Notification notification);
}
