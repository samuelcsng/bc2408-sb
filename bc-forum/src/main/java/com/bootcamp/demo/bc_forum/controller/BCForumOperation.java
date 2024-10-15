package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserDTO;

public interface BCForumOperation {

  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/jph/users")
  public List<UserDTO> getUsers();
}