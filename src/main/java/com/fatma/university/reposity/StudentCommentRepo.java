package com.fatma.university.reposity;

import com.fatma.university.model.entity.StudentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCommentRepo extends JpaRepository<StudentComment,Long> {
    Optional<StudentComment> findCommentByStudentIdAndPostId(long studentId,long postId);
    Optional<StudentComment> findCommentByStudentIdAndEventId(long studentId,long eventId);
}
