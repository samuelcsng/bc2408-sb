package com.bootcamp.demo.bc_forum_ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.demo.bc_forum_ex3.entity.User;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;

// public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
