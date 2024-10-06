package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_restapi.dto.GovCatDTO;
import com.bootcamp.demo.demo_sb_restapi.mapper.GovMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.Color;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ResponseBody
public class GovCatController {
  // Consideration: URL design (based on api consumer and resources)
  // return List<GovCatDTO>

  @GetMapping(value = "/gov/cats")
  public List<GovCatDTO> getGovCatDTOs() {
    List<Cat> cats = List.of( //
        new Cat("Peter", 10, Color.RED, 13.3), //
        new Cat("John", 11, Color.BLUE, 5.5) //
    );
    return GovMapper.map(cats);
  }
  
}
