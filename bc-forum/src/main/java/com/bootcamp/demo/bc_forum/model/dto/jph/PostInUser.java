package com.bootcamp.demo.bc_forum.model.dto.jph;

import java.util.List;

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
public class PostInUser {
  private int id;
  private String title;
  private String body;
  private List<CommentInPost> comments;
}
