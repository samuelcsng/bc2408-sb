package com.bootcamp.demo.bc_yahoo_finance.infra.yahoo;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// get key by cookie string
@Component
public class CrumbManager {
  private static final String CRUMB_URL =
      "https://query1.finance.yahoo.com/v1/test/getcrumb";

  private RestTemplate restTemplate; // Tool A (Dependency of CookieManager)
  private CookieManager cookieManager;
  private String crumb;
  String cookie;

  public CrumbManager(RestTemplate restTemplate, CookieManager cookieManager) {
    this.restTemplate = restTemplate;
    this.cookieManager = cookieManager;
    this.cookie = this.cookieManager.getCookie();
  }

  public String getCrumb() {
    String cookie = new CookieManager(new RestTemplate()).getCookie();
    System.out.println("Cookie: " + cookie);

    // String crumb = "";
    try {
      HttpHeaders headers = new HttpHeaders();
      headers.add("User-Agent", "Mozilla/5.0");
      headers.add("Cookie", cookie);
      HttpEntity<String> entity = new HttpEntity<>(headers);
      ResponseEntity<String> response = this.restTemplate.exchange(CRUMB_URL,
          HttpMethod.GET, entity, String.class);
      this.crumb = response.getBody();
      System.out.println("crumb: " + this.crumb);
      return this.crumb;
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("...Cookie...Exception...");
      System.out.println(e.getMessage());
      throw new RuntimeException("Get crumb failed...");
    }

    // return crumb;
  }

}
