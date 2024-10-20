package com.bootcamp.demo.demo_sb_restapi.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;

public interface UserService {
  List<UserEntity> saveAll(List<UserEntity> userEntities);
}
