package com.fatma.university.service.impl;

import com.fatma.university.mapper.StudentLikeVideoMapper;
import com.fatma.university.model.dto.StudentLikeVideoResponse;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Student;
import com.fatma.university.model.entity.StudentLike;
import com.fatma.university.model.entity.Video;
import com.fatma.university.reposity.StudentLikeRepo;
import com.fatma.university.service.StudentLikeVideoService;
import com.fatma.university.service.StudentService;
import com.fatma.university.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentLikeVideoServiceImpl implements StudentLikeVideoService {
    @Autowired
    private StudentLikeRepo studentLikeRepo;
    @Autowired
    private StudentService studentService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private StudentLikeVideoMapper studentLikeVideoMapper;

    @Override
    public StudentLikeVideoResponse putLikeToVideo(long studentId, long videoId) {
        Student student = studentService.getById(studentId);
        Video video = videoService.getById(videoId);
        Optional<StudentLike> studentLike=findIsLikeByStudentIdAndVideoId(studentId,videoId);
        if(studentLike.isPresent()) {
            return convertLikeAndSaveIt(studentLike.get());
        }
        else  {
            StudentLike studentLike1=new StudentLike();
            studentLike1.setLike(true);
            studentLike1.setStudent(student);
            studentLike1.setVideo(video);
            return studentLikeVideoMapper.toResponse(studentLikeRepo.save(studentLike1));
        }
    }
    private StudentLikeVideoResponse convertLikeAndSaveIt(StudentLike studentLike){
        studentLike.setLike(!studentLike.isLike());
        return studentLikeVideoMapper.toResponse(studentLikeRepo.save(studentLike));
    }

    private Optional<StudentLike> findIsLikeByStudentIdAndVideoId(long studentId, long videoId) {
        return studentLikeRepo.findIsLikeByStudentIdAndVideoId(studentId,videoId);
    }
}
