package com.ugurhmz.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {



    // IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ExceptionResponse> illegalException(Exception exception, WebRequest request) {
            ExceptionResponse exceptionResponse =
                    new ExceptionResponse(LocalDateTime.now(),"1000", exception.getMessage());

            return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }



    // ResourceNotFound Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> resourceNotFoundException(Exception exception, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "5000", exception.getMessage());

        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    // ÖNGÖREMEDİĞİMİZ HATALAR İÇİN İSE
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> generalException(Exception exception, WebRequest request) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "5050",exception.getMessage());

            return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
