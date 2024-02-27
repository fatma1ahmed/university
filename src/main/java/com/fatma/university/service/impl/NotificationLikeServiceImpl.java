package com.fatma.university.service.impl;

import com.fatma.university.model.entity.Notification;
import com.fatma.university.reposity.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationLikeServiceImpl {
    @Autowired
    private NotificationRepo notificationRepo;
    @Autowired
    private NotificationServiceImp notificationCommentService;
    public Notification updateNotificationArticle(Notification notification) {
        Notification exisitnotification=notificationCommentService.getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update Like on Article By Id " + notification.getArticleId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationEvent(Notification notification) {
        Notification exisitnotification=notificationCommentService.getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update Like on Event By Id " + notification.getEventId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationPost(Notification notification) {
        Notification exisitnotification=notificationCommentService.getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update Like on Post By Id " + notification.getPostId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationVideo(Notification notification) {
        Notification exisitnotification=notificationCommentService.getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update Like on Video By Id " + notification.getVideoId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
}
