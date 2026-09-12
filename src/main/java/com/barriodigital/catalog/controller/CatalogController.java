package com.barriodigital.catalog.controller;

import com.barriodigital.catalog.model.ProcedureType;
import com.barriodigital.catalog.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog/procedures")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping
    public ResponseEntity<ProcedureType> createProcedure(@RequestBody ProcedureType procedureType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.createProcedure(procedureType));
    }

    @GetMapping
    public ResponseEntity<List<ProcedureType>> getAllProcedures() {
        return ResponseEntity.ok(catalogService.getAllProcedures());
    }

    @PutMapping("/{id}/decrease-quota")
    public ResponseEntity<ProcedureType> decreaseQuota(@PathVariable Long id) {
        ProcedureType updatedProcedure = catalogService.decreaseQuota(id);
        return ResponseEntity.ok(updatedProcedure);
    }
}