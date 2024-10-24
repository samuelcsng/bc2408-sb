package com.bootcamp.demo.bc_yahoo_finance.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CookieManager {
  private RestTemplate restTemplate;

  public CookieManager(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  public String getCookieString() {
    // ResponseEntity<String> responseEntity =
    // this.restTemplate.getForEntity("https://fc.yahoo.com", String.class);
    // // responseEntity.getHeaders()
    // String result = responseEntity.getBody(); // getForBody()
    // return "";
    String url = "https://fc.yahoo.com";
    url = "https://query1.finance.yahoo.com/v1/test/getcrumb";
    HttpHeaders headers = new HttpHeaders();
    headers.set("User-Agent",
        "Mozilla/5.0 (Windows NT10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3");
    headers.set("Accept",
        "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,/;q=0.8");
    headers.set("Accept-Language", "en-US,en;q=0.5");
    headers.set("Referer", "https://www.example.com/");
    HttpEntity<String> entity = new HttpEntity<>(headers);

    ResponseEntity<String> response =
        this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    // this.restTemplate.getForEntity(url, String.class);
    String crumb = response.getBody();
    System.out.println("...crumb..." + crumb);

    // // HttpHeaders headers = response.getHeaders();
    // // List<String> cookies = headers.get(HttpHeaders.SET_COOKIE);
    // List<String> cookies = response.getHeaders().get(HttpHeaders.SET_COOKIE);

    // List<String> savedCookies = new ArrayList<>();
    // if (cookies != null) {
    //   savedCookies.addAll(cookies);
    //   System.out.println("Cookies saved:");
    //   for (String cookie : savedCookies) {
    //     System.out.println("Cookie: " + cookie);
    //   }
    // } else {
    //   System.out.println("No cookies found.");
    // }

    // return "";
    return crumb;

  }

  public static void main(String[] args) {
    CookieManager cookieManager = new CookieManager(new RestTemplate());
    System.out.println(cookieManager.getCookieString());
  }

}
