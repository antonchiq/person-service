package com.demo.personservice.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {

    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public HttpStatus getCode() {
        return HttpStatus.NOT_FOUND;
    }
}
