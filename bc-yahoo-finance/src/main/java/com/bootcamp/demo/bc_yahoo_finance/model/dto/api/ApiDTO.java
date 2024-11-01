package com.bootcamp.demo.bc_yahoo_finance.model.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiDTO {
  String symbol;
  Long marketTime;
  float marketPrice;
  float marketChgPercent;
  float bid;
  Long bidSize;
  float ask;
  Long askSize;
}
