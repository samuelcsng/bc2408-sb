package com.bootcamp.demo.bc_forum_ex3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private AddressEntity address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private CompanyEntity company;

    // @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostEntity> posts;
}
