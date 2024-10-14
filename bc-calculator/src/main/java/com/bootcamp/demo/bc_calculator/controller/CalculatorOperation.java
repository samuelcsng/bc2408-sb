package com.bootcamp.demo.bc_calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_calculator.model.Operation;
import com.bootcamp.demo.bc_calculator.model.ResResult;

public interface CalculatorOperation {

  @GetMapping(value = "/")
  public String getConnection();

  // GET /operation/?x=...?y=...?operation=...
  @GetMapping(value = "/operation")
  public ResponseEntity<ResResult> getOperation(@RequestParam String x,
      @RequestParam String y, @RequestParam String operation);

  // GET /operation/x/y/operation
  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  public ResponseEntity<ResResult> getOperation2(@PathVariable String x,
      @PathVariable String y, @PathVariable String operation);

  // POST /operation [JSON]
  @PostMapping(value = "/operation")
  public ResponseEntity<ResResult> postOperation(
      @RequestBody Operation operation);


}
