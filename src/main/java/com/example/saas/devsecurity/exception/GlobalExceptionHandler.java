package com.example.saas.devsecurity.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        // Log the exception
        log.error("NullPointerException occurred: ", e);

        // Return an error response
        return new ResponseEntity<>("Null pointer exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        // Log the exception
        log.error("IllegalArgumentException occurred: ", e);

        // Return an error response
        return new ResponseEntity<>("Illegal argument: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Log the exception
        log.error("Exception occurred: ", e);

        // Return an error response
        return new ResponseEntity<>("Error tracing vulnerabilities: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}