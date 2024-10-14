package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.dto.jph.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserDTO;

public interface JPHService {

  List<UserDTO> getUsers();

  List<PostDTO> getPosts();

  List<CommentDTO> getComments();

}
