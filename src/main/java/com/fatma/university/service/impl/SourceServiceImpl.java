package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.SourceMapper;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Department;
import com.fatma.university.model.entity.Source;
import com.fatma.university.reposity.SourceRepo;
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

    @Override
    public SourceResponse add(Source source) throws IOException {
        if(source.getImagePath()!=null &&!source.getImagePath().isEmpty() && source.getImagePath()!="string") {
            byte[] imageBytes = imageService.decodeBase64(source.getImagePath());
            source.setImagePath(imageService.saveImage(imageBytes));
        }
         Source savedSource=sourceRepo.save(source);

          return sourceMapper.fromEntityToResponseDto(savedSource);
    }

    @Override
    public SourceResponse update(Source source,long id) throws IOException {
      checkThisIsFoundORThrowException(id);
        Source updatedSource=sourceRepo.save(source);
        return sourceMapper.fromEntityToResponseDto(updatedSource);
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
                    Department department=source.getDepartment();
                    if (department != null) {
                        sourceResponse.setDepartmentName(department.getDepartmentName());
                    }
                    return sourceResponse;
                })

                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        checkThisIsFoundORThrowException(id);
        sourceRepo.deleteById(id);
        return new ResponseEntity<>("Source with " + id  +" is deleted",HttpStatus.ACCEPTED);

    }

    @Override
    public void checkThisIsFoundORThrowException(long id) {
        getById(id);

    }
}
