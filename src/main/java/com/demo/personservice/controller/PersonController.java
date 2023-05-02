package com.demo.personservice.controller;

import com.demo.personservice.dto.PersonDto;
import com.demo.personservice.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable final UUID id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PersonDto create(@RequestBody final PersonDto personDto) {
        return personService.create(personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final UUID id) {
        personService.delete(id);
    }
}
