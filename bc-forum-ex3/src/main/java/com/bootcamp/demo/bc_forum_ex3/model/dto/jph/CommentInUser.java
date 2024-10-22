package com.bootcamp.demo.bc_forum_ex3.model.dto.jph;

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
public class CommentInUser {
  private String name;
  private String email;
  private String body;
}
