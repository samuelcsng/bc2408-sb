package com.bootcamp.demo.demo_sb_restapi.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_sb_restapi.entity.CommentEntity;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.CommentDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.PostDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.service.PostService;
import com.bootcamp.demo.demo_sb_restapi.service.UserService;

// @Autowired(required = false)
// private CommandLineRunner runner;
// runner.run();

@Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private JPHService jphService;

  @Override
  public void run(String... args) throws Exception {
    // call jph service
    // insert into database (design tables by entity)
    List<PostDTO> posts = this.jphService.getPosts();
    List<CommentDTO> comments = this.jphService.getComments();
    List<UserDTO> users = this.jphService.getUsers();
    //
    // build List<UserEntity>
    List<UserEntity> userEntities = users.stream().map(uDto -> {
      UserEntity userEntity = //
          UserEntity.builder() //
              .name(uDto.getName()) //
              .username(uDto.getUsername()) //
              .email(uDto.getEmail()) //
              .phone(uDto.getPhone()) //
              .website(uDto.getWebsite()) //
              .build();

      // build List<PostEntity>
      List<PostEntity> postEntities = //
          posts.stream() //
              .filter(pDto -> pDto.getUserId().equals(uDto.getId())) //
              .map( // //////
                  pDto -> {
                    // build postEntity
                    PostEntity postEntity = PostEntity.builder() //
                        .title(pDto.getTitle()) // SET title
                        .body(pDto.getBody()) // AET body
                        .build();

                    // build List<CommentEntity>
                    List<CommentEntity> commentEntities = comments.stream() //
                        .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
                        .map(cDto -> {
                          CommentEntity commentEntity = CommentEntity.builder() //
                              .body(cDto.getBody()) //
                              .email(cDto.getEmail()) //
                              .name(cDto.getName()) //
                              .build();
                          commentEntity.setPost(postEntity);
                          return commentEntity;
                        }) //
                        .collect(Collectors.toList());
                    // END build List<CommentEntity>
                    postEntity.setComments(commentEntities); // SET commentEntities
                    //
                    postEntity.setUser(userEntity);
                    //
                    return postEntity;
                    // END build postEntity
                  }) //
              .collect(Collectors.toList());
      userEntity.setPosts(postEntities);
      return userEntity;
    }).collect(Collectors.toList());

    userService.saveAll(userEntities);
    ///////////////////////////////////////////////////////
    if (false) {
      // build List<PostEntity>
      List<PostEntity> postEntities = posts.stream().map(pDto -> {
        // build postEntity
        PostEntity postEntity = PostEntity.builder() //
            .title(pDto.getTitle()) // SET title
            .body(pDto.getBody()) // AET body
            .build();

        // build List<CommentEntity>
        List<CommentEntity> commentEntities = comments.stream() //
            .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
            .map(cDto -> {
              CommentEntity commentEntity = CommentEntity.builder() //
                  .body(cDto.getBody()) //
                  .email(cDto.getEmail()) //
                  .name(cDto.getName()) //
                  .build();
              commentEntity.setPost(postEntity);
              return commentEntity;
            }) //
            .collect(Collectors.toList());
        // END build List<CommentEntity>
        postEntity.setComments(commentEntities); // SET commentEntities
        //
        return postEntity;
        // END build postEntity
      }).collect(Collectors.toList());
      // END build List<PostEntity>

      // Insert into Posts, Comments
      postService.saveAll(postEntities);
    }
  }
}
