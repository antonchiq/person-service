package com.demo.personservice.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApplicationException extends RuntimeException {

    public ApplicationException(final String message) {
        this.message = message;
    }

    public ApplicationException(final HttpStatus code) {
        this.code = code;
    }

    public ApplicationException(final HttpStatus code, final String message) {
        this.code = code;
        this.message = message;
    }

    private String message;
    private HttpStatus code;

}
