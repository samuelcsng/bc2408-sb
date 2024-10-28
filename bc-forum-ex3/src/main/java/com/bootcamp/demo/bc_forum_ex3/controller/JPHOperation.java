package com.bootcamp.demo.bc_forum_ex3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum_ex3.model.dto.jph.UserPostCommentDTO;

@RequestMapping(value = "/jph")
public interface JPHOperation {

  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/users")
  public List<User> getUsers();

  @GetMapping(value = "/posts")
  public List<Post> getPosts();

  @GetMapping(value = "/comments")
  public List<Comment> getComments();

  @GetMapping(value = "/userspostscomments")
  public List<UserPostCommentDTO> getUsersPostsComments();

  @GetMapping(value = "/usercomments")
  public UserCommentsDTO getUserComments(@RequestParam String userId);

}
