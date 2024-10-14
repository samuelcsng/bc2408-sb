package com.bootcamp.demo.bc_calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_calculator.exception.CustomBusinessException;
import com.bootcamp.demo.bc_calculator.model.ResResult;

@Service
public class CalculatorService {

  public ResResult serviceImpl(String x, String y, String op)
      throws CustomBusinessException {
    BigDecimal resultBD;
    try {
      Double xDouble = Double.parseDouble(x);
      Double yDouble = Double.parseDouble(y); // divide by zero
      BigDecimal xBD = BigDecimal.valueOf(xDouble);
      BigDecimal yBD = BigDecimal.valueOf(yDouble);
      switch (op.toUpperCase()) {
        case "ADD":
          resultBD = xBD.add(yBD);
          break;
        case "SUB":
          resultBD = xBD.subtract(yBD);
          break;
        case "MUL":
          resultBD = xBD.multiply(yBD);
          break;
        case "DIV":
          resultBD = xBD.divide(yBD, 5, RoundingMode.HALF_UP);
          break;
        default:
          throw new CustomBusinessException("Invalid Input.");
        // break;
      }
    } catch (Exception e) {
      throw new CustomBusinessException("Invalid Input.");
    }
    return ResResult.builder() //
        .x(x) //
        .y(y) //
        .operation(op) //
        .result(resultBD.toString()) //
        .build() //
    ;
  }
}

