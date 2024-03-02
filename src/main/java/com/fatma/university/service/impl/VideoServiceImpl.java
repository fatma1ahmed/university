package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.VideoMapper;
import com.fatma.university.model.dto.VideoRequest;
import com.fatma.university.model.dto.VideoResponse;
import com.fatma.university.model.entity.Video;
import com.fatma.university.repository.VideoRepo;
import com.fatma.university.service.VideoCategorySourceService;
import com.fatma.university.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepo videoRepo;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoCategorySourceService videoCategorySourceService;

    @Override
    public VideoResponse add(VideoRequest videoRequest) throws IOException {
        long categoryId = videoRequest.getCategoryId();
        long sourceId = videoRequest.getSourceId();
        Video video = videoMapper.toEntity(videoRequest);
//        video.setVideoPath(saveVideoToBase64(video.getVideoPath()));
        videoCategorySourceService.assignVideoToCategoryAndSource(video, categoryId, sourceId);


        return videoMapper.toResponse(videoRepo.save(video));

    }

    @Override
    public VideoResponse update(VideoRequest videoRequest, long id) throws IOException {
        Video exisitVideo = getById(id);
        long categoryId = videoRequest.getCategoryId();
        long sourceId = videoRequest.getSourceId();
        Video video = videoMapper.toEntity(videoRequest);
        video.setVideoPath(saveVideoToBase64(video.getVideoPath()));
        videoCategorySourceService.updateVideo(video, categoryId, sourceId);
        video.setId(id);
//        video.setCreateDate(exisitVideo.getCreateDate());

        return videoMapper.toResponse(videoRepo.save(video));
    }

    @Override
    public Video getById(long id) {
        return videoRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Video with " + id + " not found")
        );

    }

    @Override
    public VideoResponse getEntityById(long id) {
        Video video = videoRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Video with " + id + " not found")
        );
        return videoMapper.toResponse(video);
    }

    @Override
    public List<VideoResponse> getAll() {
        return videoRepo.findAll().stream()
                .map(videoMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        videoRepo.deleteById(id);
        return new ResponseEntity<>("Video with " + id + " is deleted", HttpStatus.ACCEPTED);
    }

    @Override
    public List<VideoResponse> getAllForDepartment(long departmentId) {
        return videoRepo.findAllBySourceDepartmentId(departmentId).stream().map(videoMapper::toResponse).collect(Collectors.toList());
    }
    public String saveVideoToBase64(String videoPath) {
        try {
            Path filePath = Path.of(videoPath);
            byte[] VideoData = Files.readAllBytes(filePath);
            return Base64.getEncoder().encodeToString(VideoData);
        } catch (IOException e) {
            log.error("Error reading video file: {}", e.getMessage());
            return null;
        }
    }
}
