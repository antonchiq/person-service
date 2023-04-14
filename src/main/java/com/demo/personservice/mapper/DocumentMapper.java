package com.demo.personservice.mapper;

import com.demo.personservice.dto.DocumentDto;
import com.demo.personservice.model.Document;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentMapper implements IMapper<DocumentDto, Document> {

    private final ModelMapper modelMapper;

    @Override
    public Document convertToEntity(DocumentDto dto) {
        return modelMapper.map(dto, Document.class);
    }

    @Override
    public DocumentDto convertToDto(Document entity) {
        return null;
    }
}
