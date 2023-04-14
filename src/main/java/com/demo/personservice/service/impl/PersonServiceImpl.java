package com.demo.personservice.service.impl;

import com.demo.personservice.dto.PersonDto;
import com.demo.personservice.exception.NotFoundException;
import com.demo.personservice.mapper.PersonMapper;
import com.demo.personservice.repository.PersonRepository;
import com.demo.personservice.service.PersonService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto getPersonById(final UUID id) {
        final var person = personRepository.findById(id).orElseThrow(() -> new NotFoundException(
            "Person not found."));
        return personMapper.convertToDto(person);
    }

    @Override
    @Transactional
    public PersonDto create(final PersonDto personDto) {
        final var person = personMapper.convertToEntity(personDto);
        return personMapper.convertToDto(personRepository.save(person));
    }

    @Override
    public void delete(final UUID id) {
        personRepository.deleteById(id);
    }
}
