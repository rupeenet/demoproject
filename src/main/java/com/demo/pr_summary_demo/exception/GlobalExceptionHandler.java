package com.demo.pr_summary_demo.exception;

//package com.demo.prsummary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleEmployeeNotFound(
            EmployeeNotFoundException ex) {

        return Map.of("message", ex.getMessage());
    }
}