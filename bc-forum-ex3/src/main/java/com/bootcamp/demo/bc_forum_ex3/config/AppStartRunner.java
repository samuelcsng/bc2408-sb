package com.bootcamp.demo.bc_forum_ex3.config;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.bc_forum_ex3.entity.AddressEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.GeoEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.mapper.EntityMapper;
import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;
import com.bootcamp.demo.bc_forum_ex3.service.JPHService;
import com.bootcamp.demo.bc_forum_ex3.service.UserService;

// import com.bootcamp.demo.bc_forum_ex3.service.UserService2;

// @Component
// @Configuration
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  private JPHService jphService;
  //
  @Autowired
  private UserService userService;

  // @Autowired
  // private EntityMapper entityMapper;

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("...AppStartRunner Start...");

    List<User> users = this.jphService.getUsers();
    List<Post> posts = this.jphService.getPosts();
    List<Comment> comments = this.jphService.getComments();

    List<UserEntity> userEntities = //
        users.stream() //
            .map(uDto -> {
              UserEntity userEntity = //
                  UserEntity.builder() //
                      .name(uDto.getName()) //
                      .username(uDto.getUsername()) //
                      .email(uDto.getEmail()) //
                      .phone(uDto.getPhone()) //
                      .website(uDto.getWebsite()) //
                      .build();

              List<PostEntity> postEntities = //
                  posts.stream() //
                      .filter(pDto -> pDto.getUserId().equals(uDto.getId())) //
                      .map(pDto -> {
                        PostEntity postEntity = //
                            PostEntity.builder() //
                                .title(pDto.getTitle()) //
                                .body(pDto.getBody()) //
                                .build();

                        List<CommentEntity> commentEntities = //
                            comments.stream() //
                                .filter(cDto -> cDto.getPostId()
                                    .equals(pDto.getId())) //
                                .map(cDto -> {
                                  CommentEntity commentEntity = //
                                      CommentEntity.builder() //
                                          .name(cDto.getName()) //
                                          .email(cDto.getEmail()) //
                                          .body(cDto.getBody()) //
                                          .build();

                                  commentEntity.setPost(postEntity); // comment.Post

                                  return commentEntity;
                                }).collect(Collectors.toList()); // collect to commentEntities

                        postEntity.setComments(commentEntities); // post.comments

                        postEntity.setUser(userEntity); // post.user

                        return postEntity;
                      }).collect(Collectors.toList()); // collect to postEntities

              userEntity.setPosts(postEntities); // user.posts


              // todo set userEntity.companyEntity
              CompanyEntity companyEntity = CompanyEntity.builder() //
                  .name(uDto.getCompany().getName()) //
                  .catchPhrase(uDto.getCompany().getCatchPhrase()) //
                  .bs(uDto.getCompany().getBs()) //
                  .build();
              companyEntity.setUser(userEntity); // company.user
              userEntity.setCompany(companyEntity); // user.company

              // todo set usetEntity.addressEntity
              AddressEntity addressEntity = AddressEntity.builder() //
                  .street(uDto.getAddress().getStreet()) //
                  .suite(uDto.getAddress().getSuite()) //
                  .city(uDto.getAddress().getCity()) //
                  .zipcode(uDto.getAddress().getZipcode()) //
                  .build();

              // todo set userEntity.address.geoEntity
              GeoEntity geoEntity = GeoEntity.builder() //
                  .lat(uDto.getAddress().getGeo().getLat()) //
                  .lng(uDto.getAddress().getGeo().getLng()) //
                  .build();
              geoEntity.setAddress(addressEntity); // geo.address
              addressEntity.setGeo(geoEntity); // address.geo

              addressEntity.setUser(userEntity); // address.user
              userEntity.setAddress(addressEntity); // user.address

              return userEntity;
            }).collect(Collectors.toList()); // collect to usetEntities

    userService.saveAll(userEntities);

    System.out.println("...AppStartRunner End...");
  }

}
