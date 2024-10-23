package com.bootcamp.demo.bc_forum_ex3.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.dto.AddressDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.CommentDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.CompanyDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.GeoDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.PostDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.AddressEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.GeoEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.exception.CustomException3;
import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;
import com.bootcamp.demo.bc_forum_ex3.service.JPHService;

@Service
public class JPHServiceImpl implements JPHService {

  private final String JSON_PLACEHOLDER_USERS_URL = "https://jsonplaceholder.typicode.com/users";
  private final String JSON_PLACEHOLDER_POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
  private final String JSON_PLACEHOLDER_COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";

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
      throw new CustomException3("RestTemplate Error - JsonPlaceHolder");
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
      throw new CustomException3("RestTemplate Error - JsonPlaceHolder");
    }
    return List.of(posts);
  }

  @Override
  public List<Comment> getComments() {
    Comment[] comments = new Comment[0];
    try {
      comments = this.restTemplate.getForObject(
          "https://jsonplaceholder.typicode.com/comments", Comment[].class);
      // comments = this.restTemplate.getForObject(
      //     "https://jsonplaceholder.typicode.com/comments999", Comment[].class); // RestTemplate Exception
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new CustomException3("RestTemplate Error - JsonPlaceHolder");
    }
    return List.of(comments);
  }

  @Override
  public List<UserDTO> fetchUsers() {
        UserEntity[] users = restTemplate.getForObject(JSON_PLACEHOLDER_USERS_URL, UserEntity[].class);
        return Arrays.stream(users)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

  @Override
  public List<PostDTO> fetchPosts() {
    PostEntity[] posts = restTemplate.getForObject(JSON_PLACEHOLDER_POSTS_URL, PostEntity[].class);
    return Arrays.stream(posts)
            .map(this::convertPostToDTO)
            .collect(Collectors.toList());
}

  @Override
  public List<CommentDTO> fetchComments() {
    CommentEntity[] comments = restTemplate.getForObject(JSON_PLACEHOLDER_COMMENTS_URL, CommentEntity[].class);
    return Arrays.stream(comments)
            .map(this::convertToDTO)
            .collect(Collectors.toList());
}

    private UserDTO convertToDTO(UserEntity user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone()) // Set the phone field
                .website(user.getWebsite()) // Set the website field
                .address(convertAddressToDTO(user.getAddress()))
                .company(convertCompanyToDTO(user.getCompany()))
                .build();
    }

    private AddressDTO convertAddressToDTO(AddressEntity address) {
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(convertGeoToDTO(address.getGeo()))
                .build();
    }

    private GeoDTO convertGeoToDTO(GeoEntity geo) {
        return GeoDTO.builder()
                .id(geo.getId())
                .lat(geo.getLat())
                .lng(geo.getLng())
                .build();
    }

    private CompanyDTO convertCompanyToDTO(CompanyEntity company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    private PostDTO convertPostToDTO(PostEntity post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .userId(post.getUser().getId()) // Set userId field
                .build();
    }

    private CommentDTO convertToDTO(CommentEntity comment) {
      return CommentDTO.builder()
              .id(comment.getId())
              .name(comment.getName())
              .email(comment.getEmail())
              .body(comment.getBody())
              .postId(comment.getPost().getId()) // Set postId field
              .build();
  }
}
