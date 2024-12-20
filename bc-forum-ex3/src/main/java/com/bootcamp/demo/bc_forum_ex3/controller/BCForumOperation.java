package com.bootcamp.demo.bc_forum_ex3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserPostCommentDTO;

@RequestMapping(value = "/repository")
public interface BCForumOperation {

  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/users")
  public List<UserDTO> getUsers();

  @GetMapping(value = "/posts")
  public List<PostEntity> getPosts();

  @GetMapping(value = "/comments")
  public List<CommentEntity> getComments();

  @GetMapping(value = "/userspostscomments")
  public List<UserPostCommentDTO> getUsersPostsComments();

  @GetMapping(value = "/usercomments")
  public UserCommentsDTO getUserComments(@RequestParam String userId);

  @GetMapping(value = "/user")
  public UserDTO getUser(@RequestParam String userId);
}
