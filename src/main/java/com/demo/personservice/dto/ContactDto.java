package com.demo.personservice.dto;

import com.demo.personservice.constant.ContactType;
import java.util.UUID;
import lombok.Data;

@Data
public class ContactDto {

    private UUID id;
    private ContactType type;
    private String value;
    private Boolean primary;
    private UUID personId;
}
