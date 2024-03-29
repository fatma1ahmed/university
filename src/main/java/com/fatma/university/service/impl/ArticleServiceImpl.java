package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.ArticleMapper;
import com.fatma.university.model.dto.ArticleRequest;
import com.fatma.university.model.dto.ArticleResponse;
import com.fatma.university.model.entity.Article;
import com.fatma.university.repository.ArticleRepo;
import com.fatma.university.service.ArticleService;
import com.fatma.university.service.ArticleSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private ArticleSourceService articleSourceService;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ImageServiceImpl imagesService;

    @Override
    public ArticleResponse add(ArticleRequest articleRequest) throws IOException {
        Article article = articleMapper.toEntity(articleRequest);
        long sourceId = articleRequest.getSourceId();
        articleSourceService.assignArticleToSource(article, sourceId);
//        article.setImagePath(imagesService.saveImageToBase64(article.getImagePath()));
        return articleMapper.toResponse(articleRepo.save(article));
    }

    @Override
    public ArticleResponse update(ArticleRequest articleRequest, long id) throws IOException {
        long sourceId = articleRequest.getSourceId();
        Article article = articleMapper.toEntity(articleRequest);
        articleSourceService.updateSource(article, sourceId);
        article.setId(id);
//        article.setImagePath(imagesService.saveImageToBase64(article.getImagePath()));
        return articleMapper.toResponse(articleRepo.save(article));
    }

    @Override
    public Article getById(long id) {
        return articleRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Article with " + id + " not found")
        );
    }

    @Override
    public ArticleResponse getEntityById(long id) {
        Article article=articleRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this Article with " + id + " not found")
        );

        return articleMapper.toResponse(article);
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

    @Override
    public List<ArticleResponse> getAllForDepartment(long departmentId) {
        return articleRepo.findAllBySourceDepartmentId(departmentId).stream().map(articleMapper::toResponse).collect(Collectors.toList());
    }
}
