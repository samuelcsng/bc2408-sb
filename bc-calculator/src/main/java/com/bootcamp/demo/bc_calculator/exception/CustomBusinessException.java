package com.bootcamp.demo.bc_calculator.exception;

public class CustomBusinessException extends RuntimeException {
  public CustomBusinessException(String message) {
    super(message);
  }
}
