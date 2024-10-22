package com.bootcamp.demo.bc_forum_ex3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone; // Added phone field
  private String website; // Added website field
  private AddressDTO address;
  private CompanyDTO company;
}
