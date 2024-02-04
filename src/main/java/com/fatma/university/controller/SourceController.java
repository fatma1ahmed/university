package com.fatma.university.controller;

import com.fatma.university.model.dto.SourceRequest;
import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Event;
import com.fatma.university.model.entity.Source;
import com.fatma.university.service.SourceDepartmentService;
import com.fatma.university.service.SourceService;
import com.fatma.university.service.impl.SourceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {
    @Autowired
    private SourceService sourceService;
    @Autowired
    private SourceDepartmentService sourceDepartmentService;
    @PostMapping("/addSource")
    public SourceResponse assignSourceToDepartment(@RequestBody @Valid SourceRequest sourceRequest) throws IOException {
        return sourceService.add(sourceRequest);
    }
    @PutMapping("/updateSource/{id}")
    public SourceResponse updateSource(@RequestBody @Valid SourceRequest sourceRequest,@PathVariable long id) throws IOException {
        return sourceService.update(sourceRequest,id);
    }
    @GetMapping("/getSourceById/{id}")
    public Source getById(@PathVariable long id) {
        return sourceService.getById(id);
    }
    @GetMapping("/getAllSources")
    public List<SourceResponse> getAll() {
        return sourceService.getAll();
    }
    @DeleteMapping("/deleteSourceById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return sourceService.deleteById(id);
    }
    @GetMapping("/getAllEventsBySourceId/{sourceId}")
    public List<Event> getEventsBySourceId(long sourceId) {
        return sourceService.getEventsBySourceId(sourceId);
    }
    @GetMapping("/getAllSourcesByDepartmentId/{departmentId}")
    public  List<Source> getSourcesByDepartmentId(long departmentId){
        return sourceDepartmentService.getSourcesByDepartmentId(departmentId);
    }

}
