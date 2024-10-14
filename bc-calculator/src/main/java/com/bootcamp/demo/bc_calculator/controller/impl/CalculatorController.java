package com.bootcamp.demo.bc_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_calculator.controller.CalculatorOperation;
import com.bootcamp.demo.bc_calculator.model.Operation;
import com.bootcamp.demo.bc_calculator.model.ResResult;
import com.bootcamp.demo.bc_calculator.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorOperation {

  @Autowired
  CalculatorService calculatorService;

  @Override
  public String getConnection() {
    System.out.println("Get Connection ...");
    return "API Connected ...";
  }

  @Override
  public ResponseEntity<ResResult> getOperation(String x, String y, String operation) {
    System.out.println("Get Method1 ...");
    return ResponseEntity.ok( //
        calculatorService.serviceImpl(x, y, operation) //
    );
  }

  @Override
  public ResponseEntity<ResResult> getOperation2(String x, String y,
      String operation) {
    System.out.println("Get Method2 ...");
    return ResponseEntity.ok( //
        calculatorService.serviceImpl(x, y, operation) //
    );
  }

  @Override
  public ResponseEntity<ResResult> postOperation(Operation operation) {
    System.out.println("Post Method1 ...");
    return ResponseEntity.ok( //
        calculatorService.serviceImpl(operation.getX(), operation.getY(),
            operation.getOperation()) //
    );
  }

}
