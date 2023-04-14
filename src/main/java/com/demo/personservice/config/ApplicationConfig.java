package com.demo.personservice.config;

import com.demo.personservice.dto.PersonDto;
import com.demo.personservice.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        final var modelMapper = new ModelMapper();
        modelMapper.typeMap(PersonDto.class, Person.class).addMappings(mapping -> mapping.skip(
            Person::setAddresses));
        return modelMapper;
    }
}
