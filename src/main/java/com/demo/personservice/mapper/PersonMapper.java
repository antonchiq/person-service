package com.demo.personservice.mapper;

import com.demo.personservice.dto.PersonDto;
import com.demo.personservice.model.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@AllArgsConstructor
public class PersonMapper implements IMapper<PersonDto, Person> {

    private final ModelMapper modelMapper;
    private final AddressMapper addressMapper;

    @Override
    public Person convertToEntity(PersonDto dto) {
        final var person = modelMapper.map(dto, Person.class);
        if (!CollectionUtils.isEmpty(dto.getAddresses())) {
            dto.getAddresses().forEach(addressDto -> person.addAddress(addressMapper
                .convertToEntity(addressDto)));
        }

        if (!CollectionUtils.isEmpty(person.getDocuments())) {
            person.getDocuments().forEach(document -> document.setPerson(person));
        }

        if (!CollectionUtils.isEmpty(person.getContacts())) {
            person.getContacts().forEach(contact -> contact.setPerson(person));
        }
        return person;
    }

    @Override
    public PersonDto convertToDto(Person entity) {
        return modelMapper.map(entity, PersonDto.class);
    }
}
