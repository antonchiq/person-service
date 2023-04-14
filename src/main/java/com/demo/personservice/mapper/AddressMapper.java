package com.demo.personservice.mapper;

import com.demo.personservice.dto.AddressDto;
import com.demo.personservice.model.Address;
import com.demo.personservice.service.RegionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapper implements IMapper<AddressDto, Address> {

    private final ModelMapper modelMapper;
    private final RegionService regionService;

    @Override
    public Address convertToEntity(AddressDto dto) {
        final var address = modelMapper.map(dto, Address.class);
        address.setRegion(regionService.getRegionById(dto.getRegionId()));
        return address;
    }

    @Override
    public AddressDto convertToDto(Address entity) {
        return null;
    }
}
