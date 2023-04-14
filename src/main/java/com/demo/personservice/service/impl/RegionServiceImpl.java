package com.demo.personservice.service.impl;

import com.demo.personservice.exception.NotFoundException;
import com.demo.personservice.model.Region;
import com.demo.personservice.repository.RegionRepository;
import com.demo.personservice.service.RegionService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    @Override
    public Region getRegionById(UUID id) throws NotFoundException {
        return regionRepository.findById(id).orElseThrow(
            () -> new NotFoundException(String.format("Region with id %s not found.", id)));
    }
}
