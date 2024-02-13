package com.fatma.university.service;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SourceService extends CrudService<Source, SourceRequest, SourceResponse> {
    public List<Post> getAllPostsBySourceId(long sourceId);
    public List<Video> getAllVideosBySourceId(long sourceId);
    public List<Article> getAllArticleBySourceId(long sourceId);
}
