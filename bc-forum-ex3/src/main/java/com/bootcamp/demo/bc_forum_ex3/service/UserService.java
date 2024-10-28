package com.bootcamp.demo.bc_forum_ex3.service;

import java.util.List;

import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;

public interface UserService {

  List<UserEntity> saveAll(List<UserEntity> userEntities);

  List<UserEntity> getUsers();

  UserEntity getUserById(Long id);
}
