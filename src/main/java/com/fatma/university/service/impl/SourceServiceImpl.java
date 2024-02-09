package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.SourceMapper;
import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.*;
import com.fatma.university.reposity.SourceRepo;
import com.fatma.university.service.SourceDepartmentService;
import com.fatma.university.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceRepo sourceRepo;
    @Autowired
    private ImageServiceImpl imageService;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private SourceDepartmentService sourceDepartmentService;

    @Override
    public SourceResponse add(SourceRequest sourceRequest) throws IOException {
        long departmentId=sourceRequest.getDepartmentId();
        Source source=sourceMapper.toEntity(sourceRequest);
        if(source.getImagePath()!=null &&!source.getImagePath().isEmpty() && source.getImagePath()!="string") {
            byte[] imageBytes = imageService.decodeBase64(source.getImagePath());
            source.setImagePath(imageService.saveImage(imageBytes));
        }
        sourceDepartmentService.assignSourceToDepartment(source,departmentId);
        sourceRepo.save(source);
        SourceResponse sourceResponse=sourceMapper.fromEntityToResponseDto(source);
        sourceResponse.setId(source.getId());
        sourceResponse.setFullName(source.getFullName());
        sourceResponse.setEmail(source.getEmail());
        sourceResponse.setDepartmentName(source.getDepartment().getName());



          return sourceResponse;
    }

    @Override
    public SourceResponse update(SourceRequest sourceRequest,long id) throws IOException {
      getById(id);
        long departmentId=sourceRequest.getDepartmentId();
      Source source=sourceMapper.toEntity(sourceRequest);
      sourceDepartmentService.updateSource(source,departmentId);
      source.setId(id);
        sourceRepo.save(source);
        SourceResponse sourceResponse=sourceMapper.fromEntityToResponseDto(source);
        sourceResponse.setId(source.getId());
        sourceResponse.setDepartmentName(source.getDepartment().getName());
        sourceResponse.setFullName(source.getFullName());
        sourceResponse.setEmail(source.getEmail());


        return sourceResponse;
    }

    @Override
    public Source getById(long id) {
        Source source=sourceRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("this source with " + id + " not found")
        );
        return source;
    }

    @Override
    public List<SourceResponse> getAll() {

        return sourceRepo.findAll().stream()
                .map(source ->{ SourceResponse sourceResponse=sourceMapper.fromEntityToResponseDto(source);
                    if (source.getDepartment() != null) {
                        sourceResponse.setDepartmentName(source.getDepartment().getName());
                    }
                    return sourceResponse;
                })

                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        sourceRepo.deleteById(id);
        return new ResponseEntity<>("Source with " + id  +" is deleted",HttpStatus.ACCEPTED);

    }


    @Override
    public List<Post> getAllPostsBySourceId(long sourceId) {
        Source exisitSource=getById(sourceId);
        List<Post> posts=exisitSource.getPosts();
        exisitSource.setPosts(posts);
        return posts;
    }

    @Override
    public List<Video> getAllVideosBySourceId(long sourceId) {
        Source exisitSource=getById(sourceId);
        List<Video> videos=exisitSource.getVideos();
        exisitSource.setVideos(videos);
        return videos;
    }

    @Override
    public List<Article> getAllArticleBySourceId(long sourceId) {
        Source exisitSource=getById(sourceId);
        List<Article> articles=exisitSource.getArticles();
        exisitSource.setArticles(articles);
        return articles;
    }
}
