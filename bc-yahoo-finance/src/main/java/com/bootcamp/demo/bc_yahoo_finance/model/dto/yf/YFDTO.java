package com.bootcamp.demo.bc_yahoo_finance.model.dto.yf;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @JsonIgnoreProperties(ignoreUnknown = true)
public class YFDTO {

  private QuoteResponse quoteResponse;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class QuoteResponse {
    private List<Quote> result;
    private String error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public
    static class Quote {
      private String language;
      private String region;
      private String quoteType;
      private String typeDisp;
      private String quoteSourceName;
      private Boolean triggerable;
      private String customPriceAlertConfidence;
      private Boolean hasPrePostMarketData;
      private Long firstTradeDateMilliseconds;
      private Long earningsTimestamp;
      private Long earningsTimestampStart;
      private Long earningsTimestampEnd;
      private Long earningsCallTimestampStart;
      private Long earningsCallTimestampEnd;
      private Boolean isEarningsDateEstimate;
      private float trailingAnnualDividendRate;
      private float trailingPE;
      private float dividendRate;
      private float trailingAnnualDividendYield;
      private float dividendYield;
      private float epsTrailingTwelveMonths;
      private float epsForward;
      private float epsCurrentYear;
      private float priceEpsCurrentYear;
      private Long sharesOutstanding;
      private Integer priceHint;
      private float regularMarketChange;
      private Long regularMarketTime;
      private float regularMarketDayHigh;
      private String regularMarketDayRange;
      private float regularMarketDayLow;
      private Long regularMarketVolume;
      private float regularMarketPreviousClose;
      private float bid; // BD
      private float ask; // BD
      private Long bidSize;
      private Long askSize;
      private String fullExchangeName;
      private String financialCurrency;
      private float regularMarketOpen;
      private Long averageDailyVolume3Month;
      private Long averageDailyVolume10Day;
      private float fiftyTwoWeekLowChange;
      private float fiftyTwoWeekLowChangePercent;
      private String fiftyTwoWeekRange;
      private float fiftyTwoWeekHighChange;
      private float fiftyTwoWeekHighChangePercent;
      private float fiftyTwoWeekLow;
      private float fiftyTwoWeekHigh;
      private float fiftyTwoWeekChangePercent;
      private String currency;
      private float bookValue;
      private float fiftyDayAverage;
      private float fiftyDayAverageChange;
      private float fiftyDayAverageChangePercent;
      private float twoHundredDayAverage;
      private float twoHundredDayAverageChange;
      private float twoHundredDayAverageChangePercent;
      private Long marketCap;
      private float forwardPE;
      private float priceToBook;
      private Integer sourceInterval;
      private Integer exchangeDataDelayedBy;
      private String averageAnalystRating;
      private Boolean tradeable;
      private Boolean cryptoTradeable;
      private String exchange;
      private String shortName;
      private String longName;
      private String messageBoardId;
      private String exchangeTimezoneName;
      private String exchangeTimezoneShortName;
      private Long gmtOffSetMilliseconds;
      private String market;
      private Boolean esgPopulated;
      private String marketState;
      private float regularMarketChangePercent; // BD
      private float regularMarketPrice; // BigDecimal
      private String symbol;


    }
  }

}
