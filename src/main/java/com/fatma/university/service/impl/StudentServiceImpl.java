package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.StudentMapper;
import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import com.fatma.university.reposity.StudentRepo;
import com.fatma.university.service.ImagesService;
import com.fatma.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ImagesService imagesService;
    @Override
    public StudentResponse add(StudentRequest studentRequest) throws IOException {
        Student student=studentMapper.toEntity(studentRequest);
        if(student.getImagePath()!=null &&!student.getImagePath().isEmpty() && student.getImagePath()!="string") {
            byte[] imageBytes = imagesService.decodeBase64(student.getImagePath());
            student.setImagePath(imagesService.saveImage(imageBytes));
        }
        studentRepo.save(student);
        StudentResponse studentResponse=studentMapper.fromEntityToResponseDto(student);
        studentResponse.setId(student.getId());
        return studentResponse;
    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, long id) throws IOException {
        getById(id);
        Student student=studentMapper.toEntity(studentRequest);
        student.setId(id);
        studentRepo.save(student);
        StudentResponse studentResponse=studentMapper.fromEntityToResponseDto(student);
        studentResponse.setId(student.getId());
        return studentResponse;
    }

    @Override
    public Student getById(long id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this student with " + id + " not found")
        );
        return student;
    }

    @Override
    public List<StudentResponse> getAll() {
        return studentRepo.findAll().stream()
                .map(student ->studentMapper.fromEntityToResponseDto(student))
                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        studentRepo.deleteById(id);
        return new ResponseEntity<>("Source with " + id  +" is deleted", HttpStatus.ACCEPTED);

    }
}
