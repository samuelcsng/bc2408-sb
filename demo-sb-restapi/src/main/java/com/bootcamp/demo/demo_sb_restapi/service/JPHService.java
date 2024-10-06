package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

// https://jsonplaceholder.typicode.com/users
public interface JPHService {
  List<UserDTO> getUsers();
}
