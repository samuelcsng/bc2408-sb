package com.bootcamp.demo.bc_yahoo_finance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_yahoo_finance.service.StockService;

@RestController
public class StockController {

  private final StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping("/stock-price")
  public String getStockPrice(@RequestParam String symbol) {
    System.out.println("...getStockPrice...");
    // return stockService.getStockPrice(symbol);
    String result = "";
    try {
      result = stockService.getStockPrice(symbol);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return result;
  }
}
