package com.barriodigital.catalog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "procedure_types",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_code_name", columnNames = {"code", "name"})
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quitamos unique = true para permitir repetir código entre trámites distintos
    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer dailyQuota;

    @Column(nullable = false)
    private Integer availableQuota;
}