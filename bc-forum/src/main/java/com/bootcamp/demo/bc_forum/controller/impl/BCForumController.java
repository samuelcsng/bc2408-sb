package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.BCForumOperation;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;

@RestController
@RequestMapping("/api")
public class BCForumController implements BCForumOperation {

  @Autowired
  private JPHService jphService;


  @Override
  public String getConnection() {
    return "API Connected ...";
  }

  @Override
  public List<UserDTO> getUsers() {
    return this.jphService.getUsers();
  }

}
