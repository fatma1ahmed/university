package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentCommentVideoMapper;
import com.fatma.university.model.dto.StudentCommentVideoResponse;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentComment;
import com.fatma.university.model.entity.Video;
import com.fatma.university.reposity.StudentCommentRepo;
import com.fatma.university.service.StudentCommentVideoService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCommentVideoServiceImpl implements StudentCommentVideoService {
    @Autowired
    private StudentCommentRepo studentCommentRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private StudentCommentVideoMapper studentCommentVideoMapper;


    @Override
    public StudentCommentVideoResponse putCommentToVideo(long studentId, long videoId, String comment) {
        Student student = studentService.getById(studentId);
        Video video = videoService.getById(videoId);
        Optional<StudentComment> studentComment = findCommentByStudentIdAndVideoId(studentId, videoId);
        if (studentComment.isPresent()) {
            return updateCommentToVideo(studentComment.get(), comment);
        } else {
            StudentComment createComment = new StudentComment();
            createComment.setVideo(video);
            createComment.setStudent(student);
            createComment.setComment(comment);
            return studentCommentVideoMapper.toResponse(studentCommentRepo.save(createComment));
        }
    }
    private StudentCommentVideoResponse updateCommentToVideo(StudentComment studentComment, String comment){
        studentComment.setComment(comment);
        return studentCommentVideoMapper.toResponse(studentCommentRepo.save(studentComment));

    }
    private Optional<StudentComment> findCommentByStudentIdAndVideoId(long studentId, long videoId){
        return studentCommentRepo.findCommentByStudentIdAndVideoId(studentId,videoId);
    }
}
