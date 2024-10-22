package com.bootcamp.demo.bc_forum_ex3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeoDTO {
    private String lat;
    private String lng;
}