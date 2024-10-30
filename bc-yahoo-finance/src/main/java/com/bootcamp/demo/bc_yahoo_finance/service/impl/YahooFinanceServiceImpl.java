package com.bootcamp.demo.bc_yahoo_finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_yahoo_finance.infra.yahoo.CookieManager;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoo.CrumbManager;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.yf.YFDTO;
import com.bootcamp.demo.bc_yahoo_finance.service.YahooFinanceService;

@Service
public class YahooFinanceServiceImpl implements YahooFinanceService {

  private final String YAHOO_FINANCE_CRUMB_URL =
      "https://query1.finance.yahoo.com/v1/test/getcrumb";
  private final String YAHOO_FINANCE_0388_URL =
      "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0388.HK&crumb=NQfxVhc8GKR";

  @Autowired
  @Qualifier(value = "YFRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private CrumbManager crumbManager;

  @Override
  public String getCrumb() {
    // String crumb = "";
    // try {
    //   // TODO set cookiestring to headers
    //   crumb =
    //       this.restTemplate.getForObject(YAHOO_FINANCE_CRUMB_URL, String.class);
    //   System.out.println("...crumb..." + crumb);
    // } catch (RestClientException e) {
    //   System.out.println("...crump exception..." + e.getMessage());
    // }
    // String crumb = new CrumbManager(restTemplate).getCrumb();
    // System.out.println(crumb);
    // return crumb;
    return "";
  }

  @Override
  public void get0388() {
    try {
      System.out.println(
          this.restTemplate.getForObject(YAHOO_FINANCE_0388_URL, YFDTO.class));
      System.out.println("...yahoo-finance...0388.hk...");
    } catch (RestClientException e) {
      System.out.println("...get0388 exception..." + e.getMessage());
    }
  }

  @Override
  public String getCookie() {
    // TODO Auto-generated method stub
    String cookieString = new CookieManager(new RestTemplate()).getCookie();
    // System.out.println(cookieString);
    return cookieString;
    // throw new UnsupportedOperationException("Unimplemented method 'getCookie'");
  }
}
