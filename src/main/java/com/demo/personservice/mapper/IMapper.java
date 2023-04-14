package com.demo.personservice.mapper;

import com.demo.personservice.exception.NotFoundException;

public interface IMapper<D, E> {

    E convertToEntity(D dto);

    D convertToDto(E entity);
}
