package com.demo.personservice.mapper;

import com.demo.personservice.dto.ContactDto;
import com.demo.personservice.model.Contact;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContactMapper implements IMapper<ContactDto, Contact> {

    private final ModelMapper modelMapper;

    @Override
    public Contact convertToEntity(ContactDto dto) {
        return modelMapper.map(dto, Contact.class);
    }

    @Override
    public ContactDto convertToDto(Contact entity) {
        return null;
    }
}
