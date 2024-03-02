package com.fatma.university.mapper;

import com.fatma.university.model.dto.FAQRequest;
import com.fatma.university.model.dto.FAQResponse;
import com.fatma.university.model.entity.FAQ;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FAQMapper {


    FAQ  toEntity(FAQRequest faqRequest);


    @Mapping(target = "sourceId" , source = "faq.source.id")
    FAQResponse toResponse(FAQ faq);

}
