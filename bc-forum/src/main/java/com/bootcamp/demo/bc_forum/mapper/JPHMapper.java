package com.bootcamp.demo.bc_forum.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.bootcamp.demo.bc_forum.model.Comment;
import com.bootcamp.demo.bc_forum.model.Post;
import com.bootcamp.demo.bc_forum.model.User;
import com.bootcamp.demo.bc_forum.model.dto.jph.CommentInPost;
import com.bootcamp.demo.bc_forum.model.dto.jph.CommentInUser;
import com.bootcamp.demo.bc_forum.model.dto.jph.PostInUser;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserCommentsDTO;
import com.bootcamp.demo.bc_forum.model.dto.jph.UserPostCommentDTO;

public class JPHMapper {

  public static List<UserPostCommentDTO> UsersPostsComments(List<User> users,
      List<Post> posts, List<Comment> comments) {
    return users.stream() //
        .map(user -> UserPostCommentDTO.builder() //
            .id(user.getId()) //
            .name(user.getName()) //
            .username(user.getUsername()) //
            .email(user.getEmail()) //
            .phone(user.getPhone()) //
            .website(user.getWebsite()) //
            .address(user.getAddress()) //
            .company(user.getCompany()) //
            .posts(posts.stream() //
                .filter(post -> post.getUserId() == user.getId()) //
                .map(post -> PostInUser.builder() //
                    .id(post.getId()) //
                    .title(post.getTitle()) //
                    .body(post.getBody()) //
                    .comments(comments.stream() //
                        .filter(comment -> comment.getPostId() == post.getId()) //
                        .map(comment -> CommentInPost.builder() //
                            .id(comment.getId()) //
                            .name(comment.getName()) //
                            .email(comment.getEmail()) //
                            .body(comment.getBody()) //
                            .build()) //
                        .collect(Collectors.toList())) //
                    .build() //
                ) //
                .collect(Collectors.toList()))
            .build() //
        ) //
        .collect(Collectors.toList()) //
    ;
  }

  public static UserCommentsDTO UserComments(List<User> users, List<Post> posts,
      List<Comment> comments, int userIdInt) {

    List<Post> postsByUserId = posts.stream() //
        .filter(post -> post.getUserId() == userIdInt) //
        .collect(Collectors.toList());
    // System.out.println(postsByUserId.size()); // 10

    List<List<Comment>> commentsByUserIdByPostIdList = postsByUserId.stream() //
        .map(post -> comments.stream() //
            .filter(comment -> comment.getPostId() == post.getId()) //
            // .filter(comment -> comment.getPostId() == 999) // for emptyList
            .collect(Collectors.toList()) //
        ) //
        .collect(Collectors.toList());
    // System.out.println(commentsByUserIdByPostIdList.size()); // 10

    List<Comment> commentsByUserIdByPostId =
        commentsByUserIdByPostIdList.stream() //
            .flatMap(List::stream)//
            .collect(Collectors.toList());
    // System.out.println(commentsByUserIdByPostId.size()); // 50

    List<CommentInUser> commentsInUser = commentsByUserIdByPostId.stream() //
        .map(comment -> CommentInUser.builder().name(comment.getName())
            .email(comment.getEmail()).body(comment.getBody()).build() //
        ) //
        .collect(Collectors.toList());
    // System.out.println(commentsInUser.size()); // 50

    List<UserCommentsDTO> result = users.stream() //
        .filter(user -> user.getId() == userIdInt) //
        .map(user -> UserCommentsDTO.builder() //
            .id(user.getId()) //
            .username(user.getUsername()) //
            .comments(commentsInUser) //
            // .comments(List.of()) // empty list
            .build() //
        ) //
        .collect(Collectors.toList());
    // System.out.println(result.size()); // 1

    return result.get(0);
  }



}
