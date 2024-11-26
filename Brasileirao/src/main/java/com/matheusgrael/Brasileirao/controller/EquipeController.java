package com.matheusgrael.Brasileirao.controller;

import com.matheusgrael.Brasileirao.dominio.Equipe;
import com.matheusgrael.Brasileirao.dominio.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
    public ResponseEntity<Map<UUID, Equipe>> listagem() {
        return ResponseEntity.ok(equipeRepository.listEquipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> buscarPorId(@PathVariable UUID id) {
        Equipe equipe = equipeRepository.getEquipeById(id);
        if(equipe != null) {
        return ResponseEntity.ok(equipe);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        if (equipeRepository.getEquipeById(id) != null) {
            equipeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }





}
