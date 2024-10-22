package com.bootcamp.demo.demo_sb_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {

  @Scheduled(fixedDelay = 5000) // 5000ms = 5s
  public void sayHello(){
    System.out.println("Task A hello world... + time = " + System.currentTimeMillis());
  }
  
  // fixedRate
  @Scheduled(fixedRate = 3000)
  public void sayBye() throws Exception{
    System.out.println("Task B Starts. time=" + System.currentTimeMillis());
    Thread.sleep(6000);
    System.out.println("Task B Ends. time=" + System.currentTimeMillis());
  }
}

