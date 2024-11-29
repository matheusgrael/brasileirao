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
        return ResponseEntity.ok(equipeRepository.listAllEquipes());
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

    @GetMapping("/uf")
//    @RequestParam?
//    A anotação @RequestParam é usada para capturar valores enviados como parâmetros de consulta (query parameters) na URL.
//    Por padrão, os parâmetros são obrigatórios, mas você pode configurá-los como opcionais com required = false.
//Se o cliente faz uma requisição como://
//    GET /equipe/uf?estado=RJ//
//    Captura o valor do parâmetro estado ("RJ") e o associa à variável estado.
//    Requisição sem incluir os parâmetros:
//    GET /equipe/uf
//    Como o required = false, estado será atribuído como null
    public ResponseEntity<Map<UUID, Equipe>> buscarPorEstado(@RequestParam(required = false) String uf) {
        Map<UUID, Equipe> equipes = equipeRepository.listAllEquipes();
        if(uf != null) {
            equipes.values().removeIf(e -> !e.getEstado().equalsIgnoreCase(uf));
        }
        return ResponseEntity.ok(equipes);
    }







}
