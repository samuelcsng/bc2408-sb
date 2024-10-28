package com.bootcamp.demo.bc_forum_ex3.controller.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_forum_ex3.controller.JPHOperation;
import com.bootcamp.demo.bc_forum_ex3.exception.CustomException1;
import com.bootcamp.demo.bc_forum_ex3.exception.CustomException2;
import com.bootcamp.demo.bc_forum_ex3.exception.CustomException3;
import com.bootcamp.demo.bc_forum_ex3.mapper.JPHMapper;
import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserPostCommentDTO;
import com.bootcamp.demo.bc_forum_ex3.service.JPHService;

@RestController
public class JPHController implements JPHOperation{

  @Autowired
  private JPHService jphService;

  @Override
  public String getConnection() {
    System.out.println("...jph:getConnection...");
    return LocalTime.now() + "...jph_API_Connected...";
  }

  @Override
  public List<User> getUsers() {
    System.out.println("...jph:getUsers...");
    return this.jphService.getUsers();
  }

  @Override
  public List<Post> getPosts() {
    System.out.println("...jph:getPosts...");
    return this.jphService.getPosts();
  }

  @Override
  public List<Comment> getComments() {
    System.out.println("...jph:getComments...");
    return this.jphService.getComments();
  }

  @Override
  public List<UserPostCommentDTO> getUsersPostsComments() {
    System.out.println("...jph:getUsersPostsComments...");

    List<User> users = this.jphService.getUsers();
    List<Post> posts = this.jphService.getPosts();
    List<Comment> comments = this.jphService.getComments();
    return JPHMapper.UsersPostsComments(users, posts, comments);
  }

  @Override
  public UserCommentsDTO getUserComments(String userId) {
    System.out.println("...jph:getUserComments...");

    Integer userIdInt;
    try {
      userIdInt = Integer.parseInt(userId); // Exception Handling
    } catch (Exception e) {
      // throw new CustomException1("User not found");
      throw new CustomException2("Invalid Input");
      // throw new CustomException3("RestTemplate Error - JsonPlaceHolder");
    }

    List<User> users;
    List<Post> posts;
    List<Comment> comments;
    try {
      users = this.jphService.getUsers();
      posts = this.jphService.getPosts();
      comments = this.jphService.getComments();
      // throw new Exception();
    } catch (Exception e) {
      throw new CustomException3("RestTemplate Error - JsonPlaceHolder");
    }

    UserCommentsDTO userCommentsDTO;
    try {
      userCommentsDTO =
          JPHMapper.UserComments(users, posts, comments, userIdInt);
    } catch (Exception e) {
      throw new CustomException1("User not found");
    }
    return userCommentsDTO;
    // return JPHMapper.UserComments(users, posts, comments, userIdInt);
  }
  
}
