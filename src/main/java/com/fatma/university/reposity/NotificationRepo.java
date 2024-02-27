package com.fatma.university.reposity;

import com.fatma.university.model.entity.Notification;
import com.fatma.university.model.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {

    List<Notification> findAllBySource(Source source);

    List<Notification> findAllByPostId(long postId);

    List<Notification> findAllByArticleId(long articleId);

    List<Notification> findAllByVideoId(long videoId);

    List<Notification> findAllByEventId(long eventId);

}
