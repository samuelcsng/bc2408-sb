package com.bootcamp.demo.forum;

import org.springframework.web.bind.annotation.GetMapping;

public interface Operation {

  @GetMapping(value = "/")
  public String getConnection();

}
