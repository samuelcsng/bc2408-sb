package com.bootcamp.demo.bc_forum_ex3.model.dto.jph;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserCommentsDTO {
  private int id;
  private String username;
  private List<CommentInUser> comments;
  // private List<Comment> comments;
}