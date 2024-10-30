package com.bootcamp.demo.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StockManager {
  // "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=NQfxVhc8GKR";
  private final String YAHOO_FINANCE_URL =
      "https://query1.finance.yahoo.com/v7/finance/quote";
  String symbols;
  String crumb;

  private final HttpClient client = HttpClient.newHttpClient();
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  CrumbManager crumbManager;

  public String getQuotes(List<String> symbols)
      throws IOException, InterruptedException {
    this.crumb = crumbManager.getCrumb();
    // this.symbols = String.join(",", symbols);
    this.symbols = symbols.stream().reduce("", (partialString, element) -> partialString.isEmpty() ? element
                : partialString + "," + element);

    String url = YAHOO_FINANCE_URL + "?symbols=" + this.symbols + "&crumb=" + crumb;

    try {
      HttpRequest request = HttpRequest.newBuilder() //
          .uri(URI.create(url)) //
          .header("Cookie", crumbManager.cookie) //
          .GET() //
          .build();
      HttpResponse<String> response =
          client.send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (InterruptedException e) {
      // TODO: handle exception
      System.out.println(e.getMessage());
      throw new InterruptedException("Get quote failed...");
    } catch (IOException e) {
      System.out.println(e.getMessage());
      throw new IOException("Get quote failed...");
    }
    // return "";
  }

}
