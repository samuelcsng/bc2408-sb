package com.bootcamp.demo.bc_yahoo_finance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.ArrayList;
import com.bootcamp.demo.bc_yahoo_finance.entity.TStockEntity;
import com.bootcamp.demo.bc_yahoo_finance.repository.TStockRepository;

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  TStockRepository tStockRepository;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("...AppStartRunner Start...");

    TStockEntity HK0388 = TStockEntity.builder().symbol("0388.HK").build();
    TStockEntity HK0700 = TStockEntity.builder().symbol("0700.HK").build();
    TStockEntity HK0005 = TStockEntity.builder().symbol("0005.HK").build();

    List<TStockEntity> tStockEntities = new ArrayList<>();
    tStockEntities.add(HK0388);
    tStockEntities.add(HK0700);
    tStockEntities.add(HK0005);

    tStockRepository.saveAll(tStockEntities);
    System.out.println(tStockRepository.findAll());

    System.out.println("...AppStartRunner End...");
  }

}
