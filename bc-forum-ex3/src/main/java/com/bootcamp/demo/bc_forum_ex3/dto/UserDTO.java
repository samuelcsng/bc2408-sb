package com.bootcamp.demo.bc_forum_ex3.dto;

import com.bootcamp.demo.bc_forum_ex3.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum_ex3.model.User.Company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;

  private AddressDTO address;
  
  private String phone;
  private String website;

  private CompanyDTO company;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class GeoDTO {
      private String lat;
      private String lng;
    }
  }
}
