package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.controller.JPHOperation;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;

@RestController
public class JPHController implements JPHOperation {
  
  @Autowired
  private JPHService jphService;

  @Override
  public List<UserDTO> getUsers() {
    return this.jphService.getUsers();
  }
}
