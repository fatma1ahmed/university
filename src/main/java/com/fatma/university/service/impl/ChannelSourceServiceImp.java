package com.fatma.university.service.impl;

import com.fatma.university.model.entity.*;
import com.fatma.university.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChannelSourceServiceImp implements ChannelSourceService{

    private final SourceService sourceService;


    @Override
    public void assignEventToSource(Event event, long sourceId) {
        Source source = sourceService.getById(sourceId);
        event.setSource(source);
    }

    @Override
    public void assignPostToSource(Post post, long sourceId) {
        Source source = sourceService.getById(sourceId);
        post.setSource(source);
    }

    @Override
    public void assignVideoToSource(Video video, long sourceId) {
        Source source = sourceService.getById(sourceId);
        video.setSource(source);
    }

    @Override
    public void assignArticleToSource(Article article, long sourceId) {
        Source source = sourceService.getById(sourceId);
        article.setSource(source);
    }
}
