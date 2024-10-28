package com.bootcamp.demo.bc_forum_ex3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.repository.UserRepository;
import com.bootcamp.demo.bc_forum_ex3.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);
  }

  @Override
  public List<UserEntity> getUsers() {
    return userRepository.findAll();
    // return userRepository.findById(1);
  }

  @Override
  public UserEntity getUserById(Long id) {
    // return userRepository.findById(id).get();
    return userRepository.findUserById(id);
  }

}
