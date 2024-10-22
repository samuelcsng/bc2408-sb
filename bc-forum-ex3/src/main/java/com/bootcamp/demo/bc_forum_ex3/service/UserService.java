package com.bootcamp.demo.bc_forum_ex3.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.dto.CommentDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.PostDTO;
import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.Address;
import com.bootcamp.demo.bc_forum_ex3.entity.Comment;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.Company;
import com.bootcamp.demo.bc_forum_ex3.entity.Geo;
import com.bootcamp.demo.bc_forum_ex3.entity.Post;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.User;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.mapper.EntityMapper;
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

    // userRepository.save(user);
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
                //   .peek(comment -> comment.setPost(userPost)) //
                .map(comment -> Comment.builder().name(comment.getName()).email(comment.getEmail()).body(comment.getBody()).post(post).build())
                  .collect(Collectors.toList());

              userPost.setComments(relatedComments);
              return userPost;
            } //
        ) //
        .collect(Collectors.toList());
  }




      public void fetchAndStoreUsers() {
        List<UserDTO> userDTOs = jphService.fetchUsers();
        List<PostDTO> postDTOs = jphService.fetchPosts();
        List<CommentDTO> commentDTOs = jphService.fetchComments();

        for (UserDTO userDTO : userDTOs) {
            saveUser(userDTO, postDTOs, commentDTOs);
        }
    }

    private void saveUser(UserDTO userDTO, List<PostDTO> postDTOs, List<CommentDTO> commentDTOs) {
        UserEntity user = EntityMapper.toEntity(userDTO); // Use mapper to convert DTO to Entity
        user.setPosts(createPostsForUser(user, userDTO, postDTOs, commentDTOs)); // Create and set posts
        userRepository.save(user);
    }

    private List<PostEntity> createPostsForUser(UserEntity user, UserDTO userDTO, List<PostDTO> postDTOs, List<CommentDTO> commentDTOs) {
        return postDTOs.stream()
            .filter(postDTO -> postDTO.getUserId().equals(userDTO.getId())) // Ensure userId matches
            .map(postDTO -> {
                PostEntity post = EntityMapper.toEntity(postDTO); // Use mapper here
                post.setUser(user); // Associate user to post
                post.setComments(createCommentsForPost(postDTO, commentDTOs)); // Set comments for the post
                return post;
            })
            .collect(Collectors.toList()); // Collect to List
    }

    private List<CommentEntity> createCommentsForPost(PostDTO postDTO, List<CommentDTO> commentDTOs) {
        return commentDTOs.stream()
                .filter(commentDTO -> commentDTO.getPostId().equals(postDTO.getId())) // Match postId
                .map(EntityMapper::toEntity) // Use mapper here
                .collect(Collectors.toList()); // Collect to List
    }
}
