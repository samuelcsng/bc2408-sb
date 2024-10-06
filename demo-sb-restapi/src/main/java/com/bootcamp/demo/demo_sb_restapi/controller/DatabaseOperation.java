package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DatabaseOperation {

  @GetMapping(value = "/integers/put/{index}/{value}")
  public int put(@PathVariable int index, @PathVariable int value);

  @GetMapping(value = "/integers/get/{index}")
  public int get(@PathVariable int index);

  @GetMapping(value = "/integers/getall")
  public List<Integer> getAll();

}
