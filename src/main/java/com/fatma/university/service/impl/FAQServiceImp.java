package com.fatma.university.service.impl;

import com.fatma.university.mapper.FAQMapper;
import com.fatma.university.model.dto.FAQRequest;
import com.fatma.university.model.dto.FAQResponse;
import com.fatma.university.model.entity.FAQ;
import com.fatma.university.model.entity.Source;
import com.fatma.university.repository.FAQRepository;
import com.fatma.university.service.FAQService;
import com.fatma.university.service.SourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FAQServiceImp implements FAQService {

    private final FAQRepository faqRepository;
    private final SourceService sourceService;
    private final FAQMapper faqMapper;

    public FAQServiceImp(FAQRepository faqRepository, SourceService sourceService, FAQMapper faqMapper) {
        this.faqRepository = faqRepository;
        this.sourceService = sourceService;
        this.faqMapper = faqMapper;
    }

    @Override
    public FAQResponse add(FAQRequest faqRequest) throws IOException {
        Source source = sourceService.getById(faqRequest.getSourceId());
        FAQ faq
                = faqMapper.toEntity(faqRequest);
        faq.setSource(source);
        return faqMapper.toResponse(faqRepository.save(faq));
    }

    @Override
    public FAQResponse update(FAQRequest faqRequest, long id) throws IOException {
        FAQ exisingFaq = getById(id);
        Source source = sourceService.getById(faqRequest.getSourceId());

        FAQ toBeSaved
                = faqMapper.toEntity(faqRequest);
        toBeSaved.setId(exisingFaq.getId());
        toBeSaved.setSource(source);

        return faqMapper.toResponse(faqRepository.save(toBeSaved));

    }

    @Override
    public FAQ getById(long id) {
        return faqRepository.findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("No Faq with id = " + id)
                );
    }

    @Override
    public FAQResponse getEntityById(long id) {
        return faqMapper.toResponse(getById(id));
    }

    @Override
    public List<FAQResponse> getAll() {
        return faqRepository.findAll().stream().map(faqMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        getById(id);
        faqRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }
}
