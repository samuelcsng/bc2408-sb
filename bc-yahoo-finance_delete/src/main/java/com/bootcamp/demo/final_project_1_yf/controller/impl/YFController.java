package com.bootcamp.demo.final_project_1_yf.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.final_project_1_yf.controller.YFOperation;
import com.bootcamp.demo.final_project_1_yf.service.YahooFinanceService;

@RestController
public class YFController implements YFOperation {

  @Autowired
  private YahooFinanceService yahooFinanceService;

  @Override
  public String getConnection() {
    System.out.println("...getConnection...");
    return "API Connected ...!!!";
  }

  @Override
  public String getCrump() {
    System.out.println("...getCrump...");
    return this.yahooFinanceService.getCrumb();
  }

  @Override
  public String get0388() {
    System.out.println("...get0388...");
    
    return "...get0388...";
  }

}
