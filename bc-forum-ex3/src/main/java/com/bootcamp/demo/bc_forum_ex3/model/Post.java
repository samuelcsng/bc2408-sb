package com.bootcamp.demo.bc_forum_ex3.model;

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
public class Post {
  private int userId;
  private int id;
  private String title;
  private String body;

}