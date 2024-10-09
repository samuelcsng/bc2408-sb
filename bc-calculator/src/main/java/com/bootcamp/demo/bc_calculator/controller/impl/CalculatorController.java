package com.bootcamp.demo.bc_calculator.controller.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Controller
@ResponseBody
public class CalculatorController {

  @GetMapping(value = "/")
  public String getTest() {
    return "HelloHelloWorld!!!!!!!!";
  }

  // GET /operation ?x= ?y= ?operation=
  @GetMapping(value = "/operation")
  // public String getAdd(@RequestParam String x, @RequestParam String y,
  // @RequestParam String operation) {
  public ResponseEntity<ResResult> getAdd(@RequestParam String x,
      @RequestParam String y, @RequestParam String operation) {
    Double xDouble = Double.parseDouble(x);
    Double yDouble = Double.parseDouble(y);
    BigDecimal xBD = BigDecimal.valueOf(xDouble);
    BigDecimal yBD = BigDecimal.valueOf(yDouble);
    BigDecimal resultBD; // = xBD.add(yBD);
    switch (operation) {
      case "add":
        resultBD = xBD.add(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "sub":
        resultBD = xBD.subtract(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "mul":
        resultBD = xBD.multiply(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "div":
        resultBD = xBD.divide(yBD, 5, RoundingMode.HALF_UP);
        break;
      default:
        resultBD = BigDecimal.valueOf(999.99);
        break;
    }
    if ("999.99".equals(resultBD.toString())) {
      // return "operation not valid";
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(x) //
              .y(y) //
              .operation(operation) //
              .result("operation not valid") //
              .build() //
      );
    } else {
      // return "result: " + resultBD.toString();
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(x) //
              .y(y) //
              .operation(operation) //
              .result(resultBD.toString()) //
              .build() //
      );
    }
  }

  // GET /operation/x/y/operation
  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  public ResponseEntity<ResResult> getAdd2(@PathVariable String x, @PathVariable String y,
      @PathVariable String operation) {
    Double xDouble = Double.parseDouble(x);
    Double yDouble = Double.parseDouble(y);
    BigDecimal xBD = BigDecimal.valueOf(xDouble);
    BigDecimal yBD = BigDecimal.valueOf(yDouble);
    BigDecimal resultBD; // = xBD.add(yBD);
    switch (operation) {
      case "add":
        resultBD = xBD.add(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "sub":
        resultBD = xBD.subtract(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "mul":
        resultBD = xBD.multiply(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "div":
        resultBD = xBD.divide(yBD, 5, RoundingMode.HALF_UP);
        break;
      default:
        resultBD = BigDecimal.valueOf(999.99);
        break;
    }
    if ("999.99".equals(resultBD.toString())) {
      // return "operation not valid";
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(x) //
              .y(y) //
              .operation(operation) //
              .result("operation not valid") //
              .build() //
      );
    } else {
      // return "result: " + resultBD.toString();
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(x) //
              .y(y) //
              .operation(operation) //
              .result(resultBD.toString()) //
              .build() //
      );
    }
  }

  // POST /operation [JSON]
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @Builder
  public static class Operation {
    private String x;
    private String y;
    private String operation;
  }

  @PostMapping(value = "/operation")
  // public ResponseEntity<Operation>
  public ResponseEntity<ResResult> postOperation(@RequestBody Operation operation) {
    Double xDouble = Double.parseDouble(operation.getX());
    Double yDouble = Double.parseDouble(operation.getY());
    BigDecimal xBD = BigDecimal.valueOf(xDouble);
    BigDecimal yBD = BigDecimal.valueOf(yDouble);
    String operationStr = operation.getOperation();
    BigDecimal resultBD;
    switch (operationStr) {
      case "add":
        resultBD = xBD.add(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "sub":
        resultBD = xBD.subtract(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "mul":
        resultBD = xBD.multiply(yBD); // .setScale(5, RoundingMode.HALF_UP);
        break;
      case "div":
        resultBD = xBD.divide(yBD, 5, RoundingMode.HALF_UP);
        break;
      default:
        resultBD = BigDecimal.valueOf(999.99);
        break;
    }
    if ("999.99".equals(resultBD.toString())) {
      // return "operation not valid";
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(operation.getX()) //
              .y(operation.getY()) //
              .operation(operation.getOperation()) //
              .result("operation not valid") //
              .build() //
      );
    } else {
      // return "result: " + resultBD.toString();
      return ResponseEntity.ok( //
          ResResult.builder() //
              .x(operation.getX()) //
              .y(operation.getY()) //
              .operation(operation.getOperation()) //
              .result(resultBD.toString()) //
              .build() //
      );
    }
  }

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @Builder
  public static class ResResult {
    private String x;
    private String y;
    private String operation;
    private String result;
  }

}
