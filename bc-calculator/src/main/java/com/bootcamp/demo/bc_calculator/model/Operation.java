package com.bootcamp.demo.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// POST /operation [JSON]
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  @Builder
  public class Operation {
    private String x;
    private String y;
    private String operation;
  }
