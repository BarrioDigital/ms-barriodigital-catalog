package com.barriodigital.catalog.service;

import com.barriodigital.catalog.model.ProcedureType;
import com.barriodigital.catalog.repository.ProcedureTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {

    private final ProcedureTypeRepository repository;

    public CatalogService(ProcedureTypeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProcedureType createProcedure(ProcedureType procedureType) {
        return repository.save(procedureType);
    }

    public List<ProcedureType> getAllProcedures() {
        return repository.findAll();
    }

    public ProcedureType getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El trámite con ID " + id + " no existe"));
    }

    @Transactional
    public ProcedureType decreaseQuota(Long id) {
        ProcedureType procedure = getById(id);
        if (procedure.getAvailableQuota() <= 0) {
            throw new IllegalArgumentException("No hay cupos disponibles para este trámite hoy");
        }
        procedure.setAvailableQuota(procedure.getAvailableQuota() - 1);
        return repository.save(procedure);
    }

    @Transactional
    public ProcedureType addQuota(Long id, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("La cantidad de cupos a agregar debe ser mayor a cero");
        }
        ProcedureType procedure = getById(id);
        procedure.setAvailableQuota(procedure.getAvailableQuota() + quantity);
        return repository.save(procedure);
    }
}