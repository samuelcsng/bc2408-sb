package com.bootcamp.demo.bc_forum_ex3.mapper;

import com.bootcamp.demo.bc_forum_ex3.dto.*;
import com.bootcamp.demo.bc_forum_ex3.entity.*;

public class EntityMapper {

    // Map UserDTO to UserEntity
    public static UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return UserEntity.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())      // Set phone field
                .website(userDTO.getWebsite())  // Set website field
                .address(toEntity(userDTO.getAddress()))
                .company(toEntity(userDTO.getCompany()))
                .build();
    }

    // Map AddressDTO to AddressEntity
    public static AddressEntity toEntity(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return null;
        }

        return AddressEntity.builder()
                .id(addressDTO.getId())
                .street(addressDTO.getStreet())
                .suite(addressDTO.getSuite())
                .city(addressDTO.getCity())
                .zipcode(addressDTO.getZipcode())
                .user(null)
                .geo(toEntity(addressDTO.getGeo()))
                .build();
    }

    // Map GeoDTO to GeoEntity
    public static GeoEntity toEntity(GeoDTO geoDTO) {
        if (geoDTO == null) {
            return null;
        }

        return GeoEntity.builder()
                .lat(geoDTO.getLat())
                .lng(geoDTO.getLng())
                .build();
    }

    // Map CompanyDTO to CompanyEntity
    public static CompanyEntity toEntity(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            return null;
        }

        return CompanyEntity.builder()
                .name(companyDTO.getName())
                .catchPhrase(companyDTO.getCatchPhrase())
                .bs(companyDTO.getBs())
                .build();
    }

    // Map PostDTO to PostEntity
    public static PostEntity toEntity(PostDTO postDTO) {
        if (postDTO == null) {
            return null;
        }

        return PostEntity.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .body(postDTO.getBody())
                .build();
    }

    // Map CommentDTO to CommentEntity
    public static CommentEntity toEntity(CommentDTO commentDTO) {
        if (commentDTO == null) {
            return null;
        }

        return CommentEntity.builder()
                .id(commentDTO.getId())
                .name(commentDTO.getName())
                .email(commentDTO.getEmail())
                .body(commentDTO.getBody())
                .build();
    }
}