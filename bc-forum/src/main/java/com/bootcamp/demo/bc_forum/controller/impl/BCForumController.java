package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.BCForumOperation;
import com.bootcamp.demo.bc_forum.mapper.JPHMapper;
import com.bootcamp.demo.bc_forum.model.Comment;
import com.bootcamp.demo.bc_forum.model.Post;
import com.bootcamp.demo.bc_forum.model.User;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserPostCommentDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;

@RestController
// @RequestMapping("/api")
public class BCForumController implements BCForumOperation {

  @Autowired
  private JPHService jphService;


  @Override
  public String getConnection() {
    System.out.println("...getConnection...");
    return "API Connected ...!!!";
  }

  @Override
  public List<User> getUsers() {
    System.out.println("...getUsers...");
    return this.jphService.getUsers();
  }

  @Override
  public List<Post> getPosts() {
    System.out.println("...getPosts...");
    return this.jphService.getPosts();
  }

  @Override
  public List<Comment> getComments() {
    System.out.println("...getComments...");
    return this.jphService.getComments();
  }

  @Override
  public List<UserPostCommentDTO> getUsersPostsComments() {
    System.out.println("...getUsersPostsComments...");

    List<User> users = this.jphService.getUsers();
    List<Post> posts = this.jphService.getPosts();
    List<Comment> comments = this.jphService.getComments();
    return JPHMapper.UsersPostsComments(users, posts, comments);
  }

  @Override
  public UserCommentsDTO getUserComments(String userId) {
    System.out.println("...getUserComments...");
    
    Integer userIdInt = Integer.parseInt(userId); // Exception Handling
    List<User> users = this.jphService.getUsers();
    List<Post> posts = this.jphService.getPosts();
    List<Comment> comments = this.jphService.getComments();
    return JPHMapper.UserComments(users, posts, comments, userIdInt);
  }

}
