package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum.model.Comment;
import com.bootcamp.demo.bc_forum.model.Post;
import com.bootcamp.demo.bc_forum.model.User;
import com.bootcamp.demo.bc_forum.service.JPHService;

@Service
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Override
  public List<User> getUsers() {
    User[] users = new User[0];
    try {
      users = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/users", User[].class);
      // System.out.println("users count: " + users.length);
    } catch (RestClientException e) {
      System.out.println(e.getMessage());
    }
    return List.of(users);
  }

  @Override
  public List<Post> getPosts() {
    Post[] posts = new Post[0];
    try {
      posts = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/posts", Post[].class);
    } catch (RestClientException e) {
      System.out.println(e.getMessage());
    }
    return List.of(posts);
  }

  @Override
  public List<Comment> getComments() {
    Comment[] comments = new Comment[0];
    try {
      comments = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/comments", Comment[].class);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return List.of(comments);
  }

}
