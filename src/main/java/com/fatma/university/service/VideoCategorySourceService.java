package com.fatma.university.service;

import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Video;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface VideoCategorySourceService {
    public void assignVideoToCategoryAndSource(Video video, long categoryId, long sourceId) throws IOException;

    public void updateVideo(Video video,long categoryId,long sourceId) throws IOException;
}
