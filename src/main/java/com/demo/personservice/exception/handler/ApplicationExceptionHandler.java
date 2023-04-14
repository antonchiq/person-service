package com.demo.personservice.exception.handler;

import com.demo.personservice.exception.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    public ResponseEntity<Object> handleException(ApplicationException exception,
                                                  WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(),
            new HttpHeaders(), exception.getCode(), request);
    }
}
