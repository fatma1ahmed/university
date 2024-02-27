package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.NotificationMapper;
import com.fatma.university.model.dto.NotificationResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import com.fatma.university.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class NotificationServiceImp {

    private final NotificationRepo notificationRepo;
    private final SourceService sourceService;
    private final NotificationMapper notificationMapper;


    public void saveNotification(Notification notification) {
        notificationRepo.save(notification);
    }


    public List<NotificationResponse> getAllForSource(long sourceId) {
        Source source = sourceService.getById(sourceId);
        return notificationRepo.findAllBySource(source).stream().map(notificationMapper::toResponse).collect(Collectors.toList());
    }

    public List<NotificationResponse> getAllForPost(long postId) {
        return notificationRepo.findAllByPostId(postId).stream().map(notificationMapper::toResponse).collect(Collectors.toList());
    }

    public List<NotificationResponse> getAllForEvent(long eventId) {
        return notificationRepo.findAllByEventId(eventId).stream().map(notificationMapper::toResponse).collect(Collectors.toList());
    }

    public List<NotificationResponse> getAllForArticle(long articleId) {
        return notificationRepo.findAllByArticleId(articleId).stream().map(notificationMapper::toResponse).collect(Collectors.toList());
    }

    public List<NotificationResponse> getAllForVideo(long videoId) {
        return notificationRepo.findAllByVideoId(videoId).stream().map(notificationMapper::toResponse).collect(Collectors.toList());
    }

    public Notification updateNotificationArticle(Notification notification) {
        Notification exisitnotification = getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Article By Id " + notification.getArticleId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }

    public Notification updateNotificationEvent(Notification notification) {
        Notification exisitnotification = getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Event By Id " + notification.getEventId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }

    public Notification updateNotificationPost(Notification notification) {
        Notification exisitnotification = getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Post By Id " + notification.getPostId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }

    public Notification updateNotificationVideo(Notification notification) {
        Notification exisitnotification = getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Video By Id " + notification.getVideoId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }

    public Notification getById(long id) {
        return notificationRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Notification with " + id + " not found")
        );
    }

}
