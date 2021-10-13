package com.ugurhmz.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {


    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            NotFoundException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Resource Not Found" ,
                details);

        return ResponseEntity.ok(err);
    }



}
