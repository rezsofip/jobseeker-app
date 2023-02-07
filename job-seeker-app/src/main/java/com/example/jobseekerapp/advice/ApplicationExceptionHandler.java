package com.example.jobseekerapp.advice;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Set<String> handleInvalidArgument(ConstraintViolationException ex) {
        Set<String> errorSet = new HashSet<>();
        ex.getConstraintViolations().forEach(error -> {
            errorSet.add(error.getMessage());
        });
        return errorSet;
    }

}

