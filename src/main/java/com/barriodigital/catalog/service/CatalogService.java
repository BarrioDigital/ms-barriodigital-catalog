package com.barriodigital.catalog.service;

import com.barriodigital.catalog.model.ProcedureType;
import com.barriodigital.catalog.repository.ProcedureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private ProcedureTypeRepository repository;

    public List<ProcedureType> getAllProcedures() {
        return repository.findAll();
    }

    public ProcedureType createProcedure(ProcedureType procedure) {
        if (procedure.getAvailableQuota() == null) {
            procedure.setAvailableQuota(procedure.getDailyQuota());
        }
        return repository.save(procedure);
    }

    public ProcedureType getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de trámite no encontrado"));
    }

    @Transactional
    public ProcedureType decreaseQuota(Long id) {
        ProcedureType procedure = getById(id);
        if (procedure.getAvailableQuota() <= 0) {
            throw new IllegalStateException("No hay cupos disponibles para este trámite hoy");
        }
        procedure.setAvailableQuota(procedure.getAvailableQuota() - 1);
        return repository.save(procedure);
    }
}