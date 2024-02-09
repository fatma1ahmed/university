package com.fatma.university.service;

import com.fatma.university.model.dto.VideoRequest;
import com.fatma.university.model.dto.VideoResponse;
import com.fatma.university.model.entity.Video;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface VideoService extends CrudService<Video, VideoRequest, VideoResponse> {

}
