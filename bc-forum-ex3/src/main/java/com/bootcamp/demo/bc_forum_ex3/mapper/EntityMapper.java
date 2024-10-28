package com.bootcamp.demo.bc_forum_ex3.mapper;

import com.bootcamp.demo.bc_forum_ex3.entity.*;
import com.bootcamp.demo.bc_forum_ex3.model.Comment;
import com.bootcamp.demo.bc_forum_ex3.model.Post;
import com.bootcamp.demo.bc_forum_ex3.model.User;
import com.bootcamp.demo.bc_forum_ex3.model.User.Address;
import com.bootcamp.demo.bc_forum_ex3.model.User.Address.Geo;
import com.bootcamp.demo.bc_forum_ex3.model.User.Company;

public class EntityMapper {

    // Map User to UserEntity
    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        return UserEntity.builder()
                // .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .address(toEntity(user.getAddress()))
                .company(toEntity(user.getCompany()))
                .build();
    }

    // Map Address to AddressEntity
    public static AddressEntity toEntity(Address address) {
        if (address == null) {
            return null;
        }
        return AddressEntity.builder()
                // .id(address.getId())
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                // .user(null)
                .geo(toEntity(address.getGeo()))
                .build();
    }

    // Map Geo to GeoEntity
    public static GeoEntity toEntity(Geo geo) {
        if (geo == null) {
            return null;
        }
        return GeoEntity.builder()
                .lat(geo.getLat())
                .lng(geo.getLng())
                // .address(null)
                .build();
    }

    // Map Company to CompanyEntity
    public static CompanyEntity toEntity(Company company) {
        if (company == null) {
            return null;
        }
        return CompanyEntity.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                // .user(null)
                .build();
    }

    // Map Post to PostEntity
    public static PostEntity toEntity(Post post) {
        if (post == null) {
            return null;
        }
        return PostEntity.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    // Map Comment to CommentEntity
    public static CommentEntity toEntity(Comment comment) {
        if (comment == null) {
            return null;
        }
        return CommentEntity.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .body(comment.getBody())
                .build();
    }

}