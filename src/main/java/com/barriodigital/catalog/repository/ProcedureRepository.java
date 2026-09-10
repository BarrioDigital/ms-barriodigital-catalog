package com.barriodigital.catalog.repository;

import com.barriodigital.catalog.entity.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProcedureRepository extends JpaRepository<Procedure, Long> {
    List<Procedure> findByActiveTrue();
}