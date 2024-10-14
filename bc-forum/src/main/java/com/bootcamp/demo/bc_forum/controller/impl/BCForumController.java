package com.bootcamp.demo.bc_forum.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.BCForumOperation;

@RestController
// @RequestMapping("/api")
public class BCForumController implements BCForumOperation {

  // @Autowired
  // private JPHService jphService;


  @Override
  public String getConnection() {
    return "API Connected ...";
  }

  // @Override
  // public List<UserDTO> getUsers() {
  //   return this.jphService.getUsers();
  // }

}
