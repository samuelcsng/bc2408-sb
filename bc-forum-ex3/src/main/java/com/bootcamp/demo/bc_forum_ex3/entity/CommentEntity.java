package com.bootcamp.demo.bc_forum_ex3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post; // Foreign key reference to PostEntity
}
