package com.example.myntcostapi.controller;

import com.example.myntcostapi.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e){
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ErrorResponse response = new ErrorResponse();
    response.setCode("VALIDATION_EXCEPTION");
    response.setMessage(e.getMessage());
    return ResponseEntity
        .status(status)
        .body(response);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e){
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    ErrorResponse response = new ErrorResponse();
    response.setCode("RUNTIME_EXCEPTION");
    response.setMessage(e.getMessage());
    return ResponseEntity
        .status(status)
        .body(response);
  }

}
