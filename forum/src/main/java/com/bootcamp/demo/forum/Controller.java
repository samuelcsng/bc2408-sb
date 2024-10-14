package com.bootcamp.demo.forum;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements Operation {

  @Override
  public String getConnection() {
    return "API Connected ...";
  }

}
