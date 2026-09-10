package com.barriodigital.catalog.service;

import com.barriodigital.catalog.entity.Procedure;
import com.barriodigital.catalog.repository.ProcedureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProcedureService {

    private final ProcedureRepository procedureRepository;

    public List<Procedure> findAllActive() {
        return procedureRepository.findByActiveTrue();
    }

    public Optional<Procedure> findById(Long id) {
        return procedureRepository.findById(id);
    }

    public Procedure create(Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    public Optional<Procedure> update(Long id, Procedure details) {
        return procedureRepository.findById(id).map(proc -> {
            proc.setName(details.getName());
            proc.setDescription(details.getDescription());
            proc.setRequirements(details.getRequirements());
            proc.setDailyQuota(details.getDailyQuota());
            proc.setActive(details.getActive());
            return procedureRepository.save(proc);
        });
    }
}