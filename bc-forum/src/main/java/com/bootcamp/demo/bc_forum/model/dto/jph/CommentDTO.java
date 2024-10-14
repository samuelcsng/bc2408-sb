package com.bootcamp.demo.bc_forum.model.dto.jph;

import lombok.Getter;

@Getter
public class CommentDTO {
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;
}
