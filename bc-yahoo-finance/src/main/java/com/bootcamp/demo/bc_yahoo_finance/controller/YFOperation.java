package com.bootcamp.demo.bc_yahoo_finance.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface YFOperation {
  
  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/crump")
  public String getCrump();

  @GetMapping(value = "/0388")
  public String get0388();

}

