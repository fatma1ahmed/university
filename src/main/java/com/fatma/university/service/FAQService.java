package com.fatma.university.service;

import com.fatma.university.model.dto.FAQRequest;
import com.fatma.university.model.dto.FAQResponse;
import com.fatma.university.model.entity.FAQ;
import org.springframework.stereotype.Service;

@Service
public interface FAQService extends CrudService<FAQ , FAQRequest, FAQResponse>{



}
