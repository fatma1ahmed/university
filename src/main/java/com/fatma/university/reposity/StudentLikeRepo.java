package com.fatma.university.reposity;

import com.fatma.university.model.entity.StudentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StudentLikeRepo extends JpaRepository<StudentLike,Long> {
    Optional<StudentLike> findLikeByStudentIdAndPostId(long studentId, long postId);
    Optional<StudentLike> findIsLikeByStudentIdAndEventId(long studentId, long eventId);
    Optional<StudentLike> findIsLikeByStudentIdAndArticleId(long studentId, long articleId);
    Optional<StudentLike> findIsLikeByStudentIdAndVideoId(long studentId, long videoId);

}
