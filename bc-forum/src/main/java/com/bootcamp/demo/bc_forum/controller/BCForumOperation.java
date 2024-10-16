package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.demo.bc_forum.model.Comment;
import com.bootcamp.demo.bc_forum.model.Post;
import com.bootcamp.demo.bc_forum.model.User;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserPostCommentDTO;

public interface BCForumOperation {

  @GetMapping(value = "/")
  public String getConnection();

  @GetMapping(value = "/jph/users")
  public List<User> getUsers();

  @GetMapping(value = "/jph/posts")
  public List<Post> getPosts();

  @GetMapping(value = "/jph/comments")
  public List<Comment> getComments();

  @GetMapping(value = "/jph/userspostscomments")
  public List<UserPostCommentDTO> getUsersPostsComments();

  @GetMapping(value = "/jph/usercomments")
  public UserCommentsDTO getUserComments(@RequestParam String userId);

}