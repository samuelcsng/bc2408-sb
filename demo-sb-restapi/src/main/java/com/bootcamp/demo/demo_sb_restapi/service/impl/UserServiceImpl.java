package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);
  }

}
