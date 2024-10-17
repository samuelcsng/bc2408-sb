package com.bootcamp.demo.bc_forum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomException1.class)
  public ResponseEntity<ExceptionResponse> handleCustomException(
      CustomException1 ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder() //
        .code(1) //
        .message(ex.getMessage()) //
        .build();
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
        .body(exceptionResponse);
  }

  @ExceptionHandler(CustomException2.class)
  public ResponseEntity<ExceptionResponse> handleCustomException(
      CustomException2 ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder() //
        .code(2) //
        .message(ex.getMessage()) //
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(exceptionResponse);
  }

  @ExceptionHandler(CustomException3.class)
  public ResponseEntity<ExceptionResponse> handleCustomException(
      CustomException3 ex) {
    ExceptionResponse exceptionResponse = ExceptionResponse.builder() //
        .code(3) //
        .message(ex.getMessage()) //
        .build();
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
        .body(exceptionResponse);
  }

}
