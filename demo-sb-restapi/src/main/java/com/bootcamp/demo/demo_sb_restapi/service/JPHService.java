package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

// https://jsonplaceholder.typicode.com/
public interface JPHService {
  List<UserDTO> getUsers();
  
  // call API
  List<UserEntity> saveUsers();
  
  UserEntity createUser(UserEntity userEntity);

  Boolean deleteUser(Long id);

  UserEntity updateUser(Long id, UserEntity entity);

  UserEntity patchUserWebsite(Long id, String website);
}