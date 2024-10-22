package com.bootcamp.demo.bc_forum_ex3.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentInPost {
  // private int postId;
  private int id;
  private String name;
  private String email;
  private String body;
}