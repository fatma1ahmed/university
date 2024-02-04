package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.CollegeMapper;
import com.fatma.university.model.dto.CollegeRequest;
import com.fatma.university.model.dto.CollegeResponse;
import com.fatma.university.model.entity.College;
import com.fatma.university.reposity.CollegeRepo;
import com.fatma.university.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl  implements CollegeService {
    @Autowired
    private CollegeRepo collegeRepo;
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public CollegeResponse add(CollegeRequest collegeRequest) {
        College college=collegeMapper.toEntity(collegeRequest);
        collegeRepo.save(college);
        CollegeResponse collegeResponse=collegeMapper.fromEntityToResponseDto(college);
        collegeResponse.setId(college.getId());
        return collegeResponse;
    }

    @Override
    public CollegeResponse update(CollegeRequest collegeRequest,long id) {
       getById(id);
       College college=collegeMapper.toEntity(collegeRequest);
       college.setId(id);
        return collegeMapper.fromEntityToResponseDto(collegeRepo.save(college));
    }


    @Override
    public College getById(long id) {
        College college=collegeRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("College with " + id  +" not found")
        );

        return college;
    }


    @Override
    public List<CollegeResponse> getAll() {
        return collegeRepo.findAll().stream()
                .map(college -> collegeMapper.fromEntityToResponseDto(college))
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        collegeRepo.deleteById(id);
        return new ResponseEntity<>("college with " + id  +" is deleted",HttpStatus.ACCEPTED);
    }


}
