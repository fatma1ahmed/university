package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationCommentServiceImpl {
    @Autowired
    private NotificationRepo notificationRepo;


//    public Notification createNotificationArticle(long studentId,long articleId,Source source) {
//        Notification notification=new Notification();
//        notification.setMessage("Student By Id: " + studentId + " add comment on Article By Id " + studentId);
//        notification.setSource(source);
//        notification.setArticleId(articleId);
//        notification.setStudentId(studentId);
//        notification.setNotificationType(NotificationType.ARTICLE);
//
//        notificationRepo.save(notification);
//        return null;
//    }


    public Notification updateNotificationArticle(Notification notification) {
     Notification exisitnotification=getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Article By Id " + notification.getArticleId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationEvent(Notification notification) {
        Notification exisitnotification=getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Event By Id " + notification.getEventId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationPost(Notification notification) {
        Notification exisitnotification=getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Post By Id " + notification.getPostId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }
    public Notification updateNotificationVideo(Notification notification) {
        Notification exisitnotification=getById(notification.getId());
        notification.setMessage("Student By Id: " + notification.getStudentId() + " update comment on Video By Id " + notification.getVideoId());
        notification.setId(exisitnotification.getId());
        notificationRepo.save(notification);
        return null;
    }

    public Notification getById(long id){
        return notificationRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Notification with " + id + " not found")
        );
    }

}
