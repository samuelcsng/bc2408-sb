package com.bootcamp.demo.demo_sb_restapi.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.bootcamp.demo.demo_sb_restapi.dto.GovCatDTO;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;

public class GovMapper {

  public static List<GovCatDTO> map(List<Cat> cats) {
    return cats.stream() //
        .map( //
            c -> GovCatDTO.builder() //
                .tailLength(c.getTailLength()) //
                .build() //
        ) //
        .collect(Collectors.toList()) //
    ;
  }

}
