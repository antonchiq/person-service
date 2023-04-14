package com.demo.personservice.service;

import com.demo.personservice.exception.NotFoundException;
import com.demo.personservice.model.Region;
import java.util.List;
import java.util.UUID;

public interface RegionService {

    List<Region> getAllRegions();

    Region getRegionById(UUID id) throws NotFoundException;

}
