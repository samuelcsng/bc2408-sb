package com.bootcamp.demo.bc_forum_ex3.service;

import com.bootcamp.demo.bc_forum_ex3.dto.*;
import com.bootcamp.demo.bc_forum_ex3.entity.AddressEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CommentEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.GeoEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.PostEntity;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JPHService2 {

    private final RestTemplate restTemplate;
    private final String JSON_PLACEHOLDER_USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private final String JSON_PLACEHOLDER_POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private final String JSON_PLACEHOLDER_COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";

    @Autowired
    public JPHService2(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserDTO> fetchUsers() {
        UserEntity[] users = restTemplate.getForObject(JSON_PLACEHOLDER_USERS_URL, UserEntity[].class);
        return Arrays.stream(users)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<PostDTO> fetchPosts() {
        PostEntity[] posts = restTemplate.getForObject(JSON_PLACEHOLDER_POSTS_URL, PostEntity[].class);
        return Arrays.stream(posts)
                .map(this::convertPostToDTO)
                .collect(Collectors.toList());
    }

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
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(convertGeoToDTO(address.getGeo()))
                .build();
    }

    private GeoDTO convertGeoToDTO(GeoEntity geo) {
        return GeoDTO.builder()
                .lat(geo.getLat())
                .lng(geo.getLng())
                .build();
    }

    private CompanyDTO convertCompanyToDTO(CompanyEntity company) {
        return CompanyDTO.builder()
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