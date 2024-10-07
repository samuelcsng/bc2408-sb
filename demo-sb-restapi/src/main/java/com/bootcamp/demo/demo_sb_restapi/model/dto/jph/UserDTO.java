package com.bootcamp.demo.demo_sb_restapi.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserDTO {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Builder
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GEO geo;
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class GEO {
      private String lat;
      private String lng;
    }
  }
  
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Builder
  private static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
  
}
