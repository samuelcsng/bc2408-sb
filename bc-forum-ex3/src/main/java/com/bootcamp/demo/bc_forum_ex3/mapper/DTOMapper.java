package com.bootcamp.demo.bc_forum_ex3.mapper;

import com.bootcamp.demo.bc_forum_ex3.dto.UserDTO;
import com.bootcamp.demo.bc_forum_ex3.entity.UserEntity;

public class DTOMapper {

  public static UserDTO toDTO(UserEntity userEntity) {
    return //
    UserDTO.builder() //
        .id(userEntity.getId()) //
        .name(userEntity.getName()) //
        .username(userEntity.getUsername()) //
        .email(userEntity.getEmail()) //
        .phone(userEntity.getPhone()) //
        .website(userEntity.getWebsite()) //
        .company(UserDTO.CompanyDTO.builder() //
            .name(userEntity.getCompany().getName()) //
            .catchPhrase(userEntity.getCompany().getCatchPhrase()) //
            .bs(userEntity.getCompany().getBs()) //
            .build()) //
        .address(UserDTO.AddressDTO.builder() //
            .street(userEntity.getAddress().getStreet()) //
            .suite(userEntity.getAddress().getSuite()) //
            .city(userEntity.getAddress().getCity()) //
            .zipcode(userEntity.getAddress().getZipcode()) //
            .geo(UserDTO.AddressDTO.GeoDTO.builder() //
                .lat(userEntity.getAddress().getGeo().getLat()) //
                .lng(userEntity.getAddress().getGeo().getLng()) //
                .build())
            .build())
        .build();
  }

}
