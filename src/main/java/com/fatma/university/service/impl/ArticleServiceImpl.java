package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.ArticleMapper;
import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import com.fatma.university.reposity.ArticleRepo;
import com.fatma.university.service.ArticleService;
import com.fatma.university.service.ArticleSourceService;
import com.fatma.university.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private ArticleSourceService articleSourceService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ImagesService imagesService;

    @Override
    public ArticleResponse add(ArticleRequest articleRequest) throws IOException {
        Article article = articleMapper.toEntity(articleRequest);
        long sourceId = articleRequest.getSourceId();
//        if (article.getImagePath() != null && !article.getImagePath().isEmpty() && article.getImagePath() != "string") {
//            byte[] imageBytes = imagesService.decodeBase64(article.getImagePath());
//            article.setImagePath(imagesService.saveImage(imageBytes));
//        }
        articleSourceService.assignArticleToSource(article, sourceId);

        return articleMapper.toResponse(articleRepo.save(article));
    }

    @Override
    public ArticleResponse update(ArticleRequest articleRequest, long id) throws IOException {
        long sourceId = articleRequest.getSourceId();
        Article article = articleMapper.toEntity(articleRequest);
        articleSourceService.updateSource(article, sourceId);
        article.setId(id);

        return articleMapper.toResponse(articleRepo.save(article));
    }

    @Override
    public Article getById(long id) {
        return articleRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Article with " + id + " not found")
        );
    }

    @Override
    public List<ArticleResponse> getAll() {
        return articleRepo.findAll().stream()
                .map(
                        articleMapper::toResponse
                )
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        articleRepo.deleteById(id);
        return new ResponseEntity<>("Article with " + id + " is deleted", HttpStatus.ACCEPTED);
    }
}
