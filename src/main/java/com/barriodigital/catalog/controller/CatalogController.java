package com.barriodigital.catalog.controller;

import com.barriodigital.catalog.model.ProcedureType;
import com.barriodigital.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/procedures")
    public ResponseEntity<List<ProcedureType>> getAllProcedures() {
        return ResponseEntity.ok(catalogService.getAllProcedures());
    }

    @PostMapping("/procedures")
    public ResponseEntity<ProcedureType> createProcedure(@RequestBody ProcedureType procedure) {
        return ResponseEntity.status(HttpStatus.CREATED).body(catalogService.createProcedure(procedure));
    }

    @PutMapping("/procedures/{id}/decrease-quota")
    public ResponseEntity<ProcedureType> decreaseQuota(@PathVariable Long id) {
        return ResponseEntity.ok(catalogService.decreaseQuota(id));
    }
}