package com.barriodigital.catalog.controller;

import com.barriodigital.catalog.entity.Procedure;
import com.barriodigital.catalog.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/procedures")
@RequiredArgsConstructor
public class ProcedureController {

    private final ProcedureService procedureService;

    // GET /api/catalog/procedures -> Listar trámites activos
    @GetMapping
    public ResponseEntity<List<Procedure>> getAllActiveProcedures() {
        return ResponseEntity.ok(procedureService.findAllActive());
    }

    // GET /api/catalog/procedures/{id} -> Obtener detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<Procedure> getProcedureById(@PathVariable Long id) {
        return procedureService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/catalog/procedures -> Crear nuevo tipo de trámite
    @PostMapping
    public ResponseEntity<Procedure> createProcedure(@RequestBody Procedure procedure) {
        Procedure created = procedureService.create(procedure);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT /api/catalog/procedures/{id} -> Actualizar requisitos/cupos
    @PutMapping("/{id}")
    public ResponseEntity<Procedure> updateProcedure(@PathVariable Long id, @RequestBody Procedure details) {
        return procedureService.update(id, details)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}