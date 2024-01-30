package com.fatma.university.service;

import com.fatma.university.model.dto.SourceResponse;
import com.fatma.university.model.entity.Source;
import org.springframework.stereotype.Service;

@Service
public interface SourceService extends CrudService<Source,Source, SourceResponse> {
}
