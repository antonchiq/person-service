package com.demo.personservice.exception.handler;

import com.demo.personservice.exception.ApplicationException;
import com.demo.personservice.exception.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<ErrorMessage> handleException(ApplicationException exception) {
        return new ResponseEntity<>(new ErrorMessage(exception.getMessage(), new Date()), exception
            .getCode());
    }
}
