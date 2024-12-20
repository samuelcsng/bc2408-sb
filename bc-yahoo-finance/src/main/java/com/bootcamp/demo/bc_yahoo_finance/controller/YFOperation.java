package com.bootcamp.demo.bc_yahoo_finance.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface YFOperation {
  
  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/cookie")
  public String getCookie();

  @GetMapping(value = "/crumb")
  public String getCrumb();

  @GetMapping(value = "/0388")
  public String get0388();

}

