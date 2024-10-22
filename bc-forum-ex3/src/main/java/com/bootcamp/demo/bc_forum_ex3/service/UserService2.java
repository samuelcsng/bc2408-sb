package com.bootcamp.demo.bc_forum_ex3.service;

import com.bootcamp.demo.bc_forum_ex3.dto.*;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;
import com.bootcamp.demo.bc_forum_ex3.mapper.EntityMapper;
import com.bootcamp.demo.bc_forum_ex3.repository.UserRepository;
// import com.example.demo.model.*;*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService2 {

    private final UserRepository userRepository;
    private final JPHService jphService;

    @Autowired
    public UserService2(UserRepository userRepository, JPHService jphService) {
        this.userRepository = userRepository;
        this.jphService = jphService;
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