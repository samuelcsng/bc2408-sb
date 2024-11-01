package com.bootcamp.demo.bc_yahoo_finance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import com.bootcamp.demo.bc_yahoo_finance.entity.TStockEntity;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoo.CookieManager;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoo.CrumbManager;
import com.bootcamp.demo.bc_yahoo_finance.infra.yahoo.StockManager;
import com.bootcamp.demo.bc_yahoo_finance.repository.TStockRepository;

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  TStockRepository tStockRepository;

  @Autowired
  CookieManager cookieManager;

  @Autowired
  CrumbManager crumbManager;

  @Autowired
  StockManager stockManager;



  @Override
  public void run(String... args) throws Exception {
    System.out.println("...AppStartRunner Start...");

    System.out.println("...DataBase Operation start...");
    TStockEntity HK0388 = TStockEntity.builder().symbol("0388.HK").build();
    TStockEntity HK0700 = TStockEntity.builder().symbol("0700.HK").build();
    TStockEntity HK0005 = TStockEntity.builder().symbol("0005.HK").build();

    List<TStockEntity> tStockEntities = new ArrayList<>();
    tStockEntities.add(HK0388);
    tStockEntities.add(HK0700);
    tStockEntities.add(HK0005);

    tStockRepository.saveAll(tStockEntities);
    System.out.println(tStockRepository.findAll());
    System.out.println("...DataBase Operation end...");

    //
    System.out.println("...quotes fetching start...");
    String quotes =
        stockManager.getQuotes(List.of("0388.HK", "0700.HK", "0005.HK"));
    // System.out.println(quotes.length());
    System.out.println("...quotes fetching end...");



    System.out.println("...AppStartRunner End...");
  }

}
