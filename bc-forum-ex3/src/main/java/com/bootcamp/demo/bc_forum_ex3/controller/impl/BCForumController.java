package com.bootcamp.demo.bc_forum_ex3.controller.impl;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_forum_ex3.controller.BCForumOperation;
import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.mapper.DTOMapper;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserPostCommentDTO;
import com.bootcamp.demo.bc_forum_ex3.service.UserService;

@RestController
public class BCForumController implements BCForumOperation {

  @Autowired
  private UserService userService;

  @Override
  public String getConnection() {
    System.out.println("\n...repository:getConnection...");
    return LocalTime.now() + "...repository_API_Connected...";
  }

  @Override
  public List<UserDTO> getUsers() {
    System.out.println("...repository:getUsers...");
    List<UserEntity> userEntities = userService.getUsers();
    List<UserDTO> userDTOs = //
        userEntities.stream() //
            .map(uEntity -> DTOMapper.toDTO(uEntity)) //
            .collect(Collectors.toList());
    return userDTOs;
  }

  @Override
  public List<PostEntity> getPosts() {
    // TODO Auto-generated method stub
    System.out.println("...repository:getPosts...");
    return null;
    // throw new UnsupportedOperationException("Unimplemented method 'getPosts'");
  }

  @Override
  public List<CommentEntity> getComments() {
    // TODO Auto-generated method stub
    System.out.println("...repository:getComments...");
    return null;
    // throw new UnsupportedOperationException(
    // "Unimplemented method 'getComments'");
  }

  @Override
  public List<UserPostCommentDTO> getUsersPostsComments() {
    // TODO Auto-generated method stub
    System.out.println("...repository:getUsersPostsComments...");
    return null;
    // throw new UnsupportedOperationException(
    // "Unimplemented method 'getUsersPostsComments'");
  }

  @Override
  public UserCommentsDTO getUserComments(String userId) {
    // TODO Auto-generated method stub
    System.out.println("...repository:getUserComments...");
    return null;
    // throw new UnsupportedOperationException(
    // "Unimplemented method 'getUserComments'");
  }

  @Override
  public UserDTO getUser(String userId) {
    // TODO Auto-generated method stub
    System.out.println("...repository:getUserById...");
    Long usetIdLong = Long.parseLong(userId); // try
    UserEntity userEntity = userService.getUserById(usetIdLong);
    UserDTO userDTO = DTOMapper.toDTO(userEntity);
    return userDTO;
    // throw new UnsupportedOperationException("Unimplemented method 'getUser'");
  }

}
