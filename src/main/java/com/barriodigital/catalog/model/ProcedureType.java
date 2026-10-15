package com.barriodigital.catalog.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "procedure_types",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_code_name", columnNames = {"code", "name"})
    }
)
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

    // --- CONSTRUCTORES ---
    public ProcedureType() {
    }

    public ProcedureType(Long id, String code, String name, String description, Integer dailyQuota, Integer availableQuota) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.dailyQuota = dailyQuota;
        this.availableQuota = availableQuota;
    }

    // --- GETTERS Y SETTERS ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDailyQuota() {
        return dailyQuota;
    }

    public void setDailyQuota(Integer dailyQuota) {
        this.dailyQuota = dailyQuota;
    }

    public Integer getAvailableQuota() {
        return availableQuota;
    }

    public void setAvailableQuota(Integer availableQuota) {
        this.availableQuota = availableQuota;
    }

    // --- PATRÓN BUILDER (Reemplaza a @Builder) ---
    public static ProcedureTypeBuilder builder() {
        return new ProcedureTypeBuilder();
    }

    public static class ProcedureTypeBuilder {
        private Long id;
        private String code;
        private String name;
        private String description;
        private Integer dailyQuota;
        private Integer availableQuota;

        public ProcedureTypeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProcedureTypeBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ProcedureTypeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProcedureTypeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProcedureTypeBuilder dailyQuota(Integer dailyQuota) {
            this.dailyQuota = dailyQuota;
            return this;
        }

        public ProcedureTypeBuilder availableQuota(Integer availableQuota) {
            this.availableQuota = availableQuota;
            return this;
        }

        public ProcedureType build() {
            return new ProcedureType(id, code, name, description, dailyQuota, availableQuota);
        }
    }
}