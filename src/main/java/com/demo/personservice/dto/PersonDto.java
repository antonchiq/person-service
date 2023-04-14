package com.demo.personservice.dto;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class PersonDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Boolean enabled;

    private List<DocumentDto> documents;
    private List<AddressDto> addresses;
    private List<ContactDto> contacts;

}
