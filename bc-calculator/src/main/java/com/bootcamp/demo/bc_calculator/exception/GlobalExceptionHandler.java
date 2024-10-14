package com.bootcamp.demo.bc_calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bootcamp.demo.bc_calculator.model.InvalidResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomBusinessException.class)
  public ResponseEntity<InvalidResponse> handleCustomBusinessException(
      CustomBusinessException ex) {
    InvalidResponse invalidResponse = InvalidResponse.builder() //
        .code(9) //
        .message(ex.getMessage()) //
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidResponse);
  }

}
