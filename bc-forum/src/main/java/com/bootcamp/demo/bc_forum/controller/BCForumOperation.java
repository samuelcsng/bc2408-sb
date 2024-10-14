package com.bootcamp.demo.bc_forum.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BCForumOperation {

  @GetMapping(value = "/")
  public String getConnection();

  // @GetMapping(value = "/jph/users")
  // public List<UserDTO> getUsers();

}
