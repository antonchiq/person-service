package com.demo.personservice.service;

import com.demo.personservice.dto.PersonDto;
import java.util.UUID;

public interface PersonService {

    PersonDto getPersonById(UUID id);

    PersonDto create(PersonDto personDto);

    void delete(UUID id);
}
