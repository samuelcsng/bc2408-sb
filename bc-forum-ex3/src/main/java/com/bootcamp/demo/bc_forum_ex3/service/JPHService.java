package com.bootcamp.demo.bc_forum_ex3.service;

import java.util.List;

import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;



public interface JPHService {

  List<User> getUsers();

  List<Post> getPosts();

  List<Comment> getComments();

}
