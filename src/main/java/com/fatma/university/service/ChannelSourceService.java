package com.fatma.university.service;

import com.fatma.university.model.Enum.ChannelType;
import com.fatma.university.model.entity.Article;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Post;
import com.fatma.university.model.entity.Video;

public interface ChannelSourceService {

    void assignEventToSource(Event event , long sourceId );
    void assignPostToSource(Post post, long sourceId);
    void assignVideoToSource(Video video, long sourceId);
    void assignArticleToSource(Article article, long sourceId);
}
