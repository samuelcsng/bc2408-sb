package com.bootcamp.demo.bc_yahoo_finance.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_yahoo_finance.controller.YFOperation;
import com.bootcamp.demo.bc_yahoo_finance.service.YahooFinanceService;



@RestController
@RequestMapping(value = "/yahoofinance")
public class YFController implements YFOperation {

  @Autowired
  private YahooFinanceService yahooFinanceService;

  @Override
  public String getConnection() {
    System.out.println("...getConnection...");
    return "API Connected ...!!!";
  }

  @Override
  public String getCrumb() {
    System.out.println("...getCrump...");
    return this.yahooFinanceService.getCrumb();
  }

  @Override
  public String get0388() {
    System.out.println("...get0388...");
    this.yahooFinanceService.get0388();
    return "...get0388...";
  }

  @Override
  public String getCookie() {
    // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'getCookie'");
    System.out.println("...getCookie...");
    return this.yahooFinanceService.getCookie();
  }

}

