package com.bootcamp.demo.demo_sb_restapi.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Companies")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String catch_phrase;
  private String bs;

  // @Builder.Default
  // @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,
  //     fetch = FetchType.LAZY)
  // private List<UserEntity> users = new ArrayList<>();

}
