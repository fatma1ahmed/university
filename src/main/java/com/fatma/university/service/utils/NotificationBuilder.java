package com.fatma.university.service.utils;

import com.fatma.university.model.Enum.NotificationType;
import com.fatma.university.model.entity.Notification;
import com.fatma.university.model.entity.Source;

public class NotificationBuilder {

    public static Notification buildNotification(Source source, NotificationType notificationType,String message, long studentId, long channelId) {
        return switch (notificationType) {
            case POST ->
                    Notification.builder().source(source).message(message).studentId(studentId).postId(channelId).notificationType(NotificationType.POST).build();
            case EVENT ->
                    Notification.builder().source(source).message(message).studentId(studentId).eventId(channelId).notificationType(NotificationType.EVENT).build();
            case ARTICLE ->
                    Notification.builder().source(source).message(message).studentId(studentId).articleId(channelId).notificationType(NotificationType.ARTICLE).build();
            case VIDEO ->
                    Notification.builder().source(source).message(message).studentId(studentId).videoId(channelId).notificationType(NotificationType.VIDEO).build();
        };
    }

}
