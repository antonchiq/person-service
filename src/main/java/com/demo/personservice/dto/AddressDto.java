package com.demo.personservice.dto;

import com.demo.personservice.constant.AddressType;
import java.util.UUID;
import lombok.Data;

@Data
public class AddressDto {

    private UUID id;
    private AddressType type;
    private String value;
    private Boolean primary;
    private UUID regionId;
    private UUID personId;
}
