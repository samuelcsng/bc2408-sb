package com.bootcamp.demo.final_project_1_yf.model.dto.yf;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YFDTO {

  private QuoteResponse quoteResponse;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  private static class QuoteResponse {
    private List<Result> results;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Result {
      private String shortName;
      private String longName;
      private float regularMarketPrice;
    }
  }

}
