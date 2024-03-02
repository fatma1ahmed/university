package com.fatma.university.service.impl;

import com.fatma.university.exception.RecordNotFoundException;
import com.fatma.university.mapper.StudentMapper;
import com.fatma.university.model.dto.StudentRequest;
import com.fatma.university.model.dto.StudentResponse;
import com.fatma.university.model.entity.Student;
import com.fatma.university.repository.StudentRepo;
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
    private ImageServiceImpl imagesService;

    @Override
    public StudentResponse add(StudentRequest studentRequest) throws IOException {
        Student student = studentMapper.toEntity(studentRequest);
       student.setImagePath(imagesService.saveImageToBase64(student.getImagePath()));
        return studentMapper.toResponse(studentRepo.save(student));

    }

    @Override
    public StudentResponse update(StudentRequest studentRequest, long id) throws IOException {
        getById(id);
        Student student = studentMapper.toEntity(studentRequest);
        student.setId(id);
       // student.setImagePath(imagesService.saveImageToBase64(student.getImagePath()));

        return studentMapper.toResponse(studentRepo.save(student));

    }

    @Override
    public Student getById(long id) {

        return studentRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this student with " + id + " not found")
        );

    }

    @Override
    public StudentResponse getEntityById(long id) {
     Student student=studentRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException("this student with " + id + " not found")
        );
     return studentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponse> getAll() {
        return studentRepo.findAll().stream()

                .map(studentMapper::toResponse)

                .toList();
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        studentRepo.deleteById(id);
        return new ResponseEntity<>("Source with " + id + " is deleted", HttpStatus.ACCEPTED);

    }
}
