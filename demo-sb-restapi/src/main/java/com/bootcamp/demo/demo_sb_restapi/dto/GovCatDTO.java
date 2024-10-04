package com.bootcamp.demo.demo_sb_restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GovCatDTO {
  private String name;
  private double tailLength;
}