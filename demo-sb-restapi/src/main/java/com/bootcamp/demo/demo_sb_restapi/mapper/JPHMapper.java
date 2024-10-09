package com.bootcamp.demo.demo_sb_restapi.mapper;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

// JPHMapper -> object (bean) -> map
public class JPHMapper {
  // public static UserEntity map(UserDTO userDTO) {
  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
        .addrLat(userDTO.getAddress().getGeo().getLat()) //
        .addrLng(userDTO.getAddress().getGeo().getLng()) //
        .addrCity(userDTO.getAddress().getCity()) //
        .addrStreet(userDTO.getAddress().getStreet()) //
        .addrSuite(userDTO.getAddress().getSuite()) //
        .addrZipcode(userDTO.getAddress().getZipcode()) //
        .comBs(userDTO.getCompany().getBs()) //
        .comCatchPhrase(userDTO.getCompany().getCatchPhrase()) //
        .comName(userDTO.getCompany().getName()) //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .phone(userDTO.getPhone()) //
        .website(userDTO.getWebsite()) //
        .build() //
    ;
  }
}
