package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.jph.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;

@Service
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Override
  public List<UserDTO> getUsers() {
    UserDTO[] users = new UserDTO[0];
    try {
      users = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/users", UserDTO[].class);
      // System.out.println("users count: " + users.length);
    } catch (RestClientException e) {
      System.out.println(e.getMessage());
    }
    return List.of(users);
  }

  @Override
  public List<PostDTO> getPosts() {
    PostDTO[] posts = new PostDTO[0];
    try {
      posts = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/posts", PostDTO[].class);
    } catch (RestClientException e) {
      System.out.println(e.getMessage());
    }
    return List.of(posts);
  }

  @Override
  public List<CommentDTO> getComments() {
    CommentDTO[] comments = new CommentDTO[0];
    try {
      comments = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/comments", CommentDTO[].class);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return List.of(comments);
  }

}
