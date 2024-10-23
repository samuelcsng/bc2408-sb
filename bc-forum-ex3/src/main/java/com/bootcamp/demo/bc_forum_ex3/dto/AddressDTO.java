package com.bootcamp.demo.bc_forum_ex3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;
}