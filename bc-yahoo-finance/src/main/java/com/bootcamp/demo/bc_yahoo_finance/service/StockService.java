package com.bootcamp.demo.bc_yahoo_finance.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@Service
public class StockService {

  private final String YAHOO_FINANCE_URL =
      "https://query1.finance.yahoo.com/v7/finance/quote?symbols=";

  public String getStockPrice(String symbol) throws IOException {
    RestTemplate restTemplate = new RestTemplate();
    // Set headers
    HttpHeaders headers = new HttpHeaders();
    headers.set("User-Agent",
        "Mozilla/5.0 (Windows NT10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
    HttpEntity<String> entity = new HttpEntity<>(headers);
    System.out.println(
        "..." + YAHOO_FINANCE_URL + symbol + "&crumb=NQfxVhc8GKR" + "...");
    // Make the request
    ResponseEntity<String> responseEntity =
        restTemplate.exchange(YAHOO_FINANCE_URL + symbol + "&crumb=NQfxVhc8GKR",
            HttpMethod.GET, entity, String.class);
    String response = responseEntity.getBody();

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(response);

    // Check and extract the regular market price
    JsonNode resultNode = jsonNode.path("quoteResponse").path("result").get(0);
    if (resultNode.isMissingNode()) {
      return "No data found for the symbol: " + symbol;
    }

    return resultNode.path("regularMarketPrice").asText();
  }
}
