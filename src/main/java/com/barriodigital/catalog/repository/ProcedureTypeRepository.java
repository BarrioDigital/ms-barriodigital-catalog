package com.barriodigital.catalog.repository;

import com.barriodigital.catalog.model.ProcedureType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProcedureTypeRepository extends JpaRepository<ProcedureType, Long> {
    Optional<ProcedureType> findByCode(String code);
}