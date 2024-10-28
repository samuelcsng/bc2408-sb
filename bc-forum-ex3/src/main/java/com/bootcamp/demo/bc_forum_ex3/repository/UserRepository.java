package com.bootcamp.demo.bc_forum_ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findUserById(Long id);

}
