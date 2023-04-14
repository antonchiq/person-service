package com.demo.personservice.dto;

import com.demo.personservice.constant.DocumentType;
import java.util.UUID;
import lombok.Data;

@Data
public class DocumentDto {

    private UUID id;
    private DocumentType type;
    private String value;
    private UUID personId;
}
