package com.barriodigital.catalog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "procedure_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer dailyQuota;

    @Column(nullable = false)
    private Integer availableQuota;
}