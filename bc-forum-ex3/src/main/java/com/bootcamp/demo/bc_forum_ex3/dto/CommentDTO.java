package com.bootcamp.demo.bc_forum_ex3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;
    private String name;
    private String email;
    private String body;
    private Long postId; // Added postId field
}