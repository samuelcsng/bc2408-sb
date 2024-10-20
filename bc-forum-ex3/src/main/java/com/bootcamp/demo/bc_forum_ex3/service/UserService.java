package com.bootcamp.demo.bc_forum_ex3.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.entity.Address;
import com.bootcamp.demo.bc_forum_ex3.entity.Comment;
import com.bootcamp.demo.bc_forum_ex3.entity.Company;
import com.bootcamp.demo.bc_forum_ex3.entity.Geo;
import com.bootcamp.demo.bc_forum_ex3.entity.Post;
import com.bootcamp.demo.bc_forum_ex3.entity.User;
import com.bootcamp.demo.bc_forum_ex3.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  private final String JSON_PLACEHOLDER_USERS_URL =
      "https://jsonplaceholder.typicode.com/users";
  private final String JSON_PLACEHOLDER_POSTS_URL =
      "https://jsonplaceholder.typicode.com/posts";
  private final String JSON_PLACEHOLDER_COMMENTS_URL =
      "https://jsonplaceholder.typicode.com/comments";

  public void fetchAndStoreUsers() {
    User[] users = fetchUsersFromJsonPlaceholder();
    // Arrays.asList(
    // restTemplate.getForObject(JSON_PLACEHOLDER_USERS_URL, User[].class));
    List<Post> posts = Arrays.asList(
        restTemplate.getForObject(JSON_PLACEHOLDER_POSTS_URL, Post[].class));
    List<Comment> comments = Arrays.asList(restTemplate
        .getForObject(JSON_PLACEHOLDER_COMMENTS_URL, Comment[].class));

    Arrays.stream(users).forEach(user -> saveUser(user, posts, comments));
  }

  private User[] fetchUsersFromJsonPlaceholder() {
    return restTemplate.getForObject(JSON_PLACEHOLDER_USERS_URL, User[].class);
  }

  private void saveUser(User user, List<Post> posts, List<Comment> comments) {

    Address address = Address.builder() //
        .street(user.getAddress().getStreet()) //
        .suite(user.getAddress().getSuite()) //
        .city(user.getAddress().getCity()) //
        .zipcode(user.getAddress().getZipcode()) //
        .geo(Geo.builder() //
            .lat(user.getAddress().getGeo().getLat()) //
            .lng(user.getAddress().getGeo().getLng()) //
            .build())
        .build();

    Company companay = Company.builder() //
        .name(user.getCompany().getName()) //
        .catchPhrase(user.getCompany().getCatchPhrase()) //
        .bs(user.getCompany().getBs()) //
        .build();

    user.setAddress(address);
    user.setCompany(companay);

    user.setPosts(createPostsForUser(user, posts, comments));

    userRepository.save(user);
  }

  private List<Post> createPostsForUser(User user, List<Post> posts,
      List<Comment> comments) {
    return posts.stream() //
        .filter(post -> post.getUser().getId().equals(user.getId())) //
        .map( //
            post -> {
              Post userPost = Post.builder() //
                  .title(post.getTitle()) //
                  .body(post.getBody()) //
                  .user(user) //
                  .build();

              List<Comment> relatedComments = comments.stream() //
                  .filter(
                      comment -> comment.getPost().getId().equals(post.getId())) //
                  .peek(comment -> comment.setPost(userPost)) //
                  .collect(Collectors.toList());

              userPost.setComments(relatedComments);
              return userPost;
            } //
        ) //
        .collect(Collectors.toList());
  }
}
