package com.bootcamp.demo.bc_forum_ex3.model.dto.jph;

import java.util.List;

import com.bootcamp.demo.bc_forum_ex3.model.User.Address;
import com.bootcamp.demo.bc_forum_ex3.model.User.Company;

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
public class UserPostCommentDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  private List<PostInUser> posts;

}