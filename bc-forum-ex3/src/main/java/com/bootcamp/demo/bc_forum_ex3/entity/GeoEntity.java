package com.bootcamp.demo.bc_forum_ex3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "geos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lat;

    private String lng;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;
    
}