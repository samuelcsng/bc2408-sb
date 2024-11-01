package com.bootcamp.demo.bc_yahoo_finance.infra.yahoo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootcamp.demo.bc_yahoo_finance.model.dto.yf.YFDTO;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.yf.YFDTO.QuoteResponse;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.yf.YFDTO.QuoteResponse.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StockManager {
  // "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=NQfxVhc8GKR";
  private final String YAHOO_FINANCE_URL =
      "https://query1.finance.yahoo.com/v7/finance/quote";
  String symbols;
  String crumb;
  String cookie;

  private final HttpClient client = HttpClient.newHttpClient();
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  CrumbManager crumbManager;

  public String getQuotes(List<String> symbols)
      throws IOException, InterruptedException {
    this.symbols = String.join(",", symbols);
    // this.symbols = symbols.stream().reduce("", (partialString, element) -> partialString.isEmpty() ? element
    // : partialString + "," + element);
    this.crumb = crumbManager.getCrumb();
    this.cookie = crumbManager.cookie;
    String url =
        YAHOO_FINANCE_URL + "?symbols=" + this.symbols + "&crumb=" + crumb;
    System.out.println("...cookie..." + this.cookie);
    System.out.println("...crumb..." + this.crumb);
    System.out.println("...url...\n" + url);
    try {
      HttpRequest request = HttpRequest.newBuilder() //
          .uri(URI.create(url)) //
          .header("Cookie", this.cookie) //
          .GET() //
          .build();
      HttpResponse<String> response =
          client.send(request, HttpResponse.BodyHandlers.ofString());
      YFDTO yFDTO = objectMapper.readValue(response.body(), YFDTO.class);

      Stream<Quote> quoteStream = yFDTO.getQuoteResponse().getResult().stream();
      List<String> symbolsStrList = //
          quoteStream //
              .map(quote -> {
                String symbol = quote.getSymbol();
                Long marketTime = quote.getRegularMarketTime();
                float marketPrice = quote.getRegularMarketPrice();
                float marketChgPercent = quote.getRegularMarketChangePercent();
                float bid = quote.getBid();
                Long bidSize = quote.getBidSize();
                float ask = quote.getAsk();
                Long askSize = quote.getAskSize();
                
                System.out.println("...quote getted..." + symbol);
                System.out.println(marketTime);
                System.out.println(marketPrice);
                System.out.println(marketChgPercent);
                System.out.println(bid);
                System.out.println(bidSize);
                System.out.println(ask);
                System.out.println(askSize);
                return symbol;
              }) //
              .collect(Collectors.toList());
      System.out
          .println("...number of quotes getted..." + symbolsStrList.size());
      // System.out.println(yFDTO.getQuoteResponse().getError());

      return response.body();
      // return String.valueOf(response.body().length());
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
