package com.matheusgrael.Brasileirao.controller;

import com.matheusgrael.Brasileirao.dominio.Equipe;
import com.matheusgrael.Brasileirao.dominio.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping
//    public ResponseEntity listEquipes() {
//        Map<UUID, Equipe> tudo = equipeRepository.listagemDeEquipes();
//        return ResponseEntity.ok(tudo);
    ResponseEntity<Map<UUID, Equipe>> listagem() {
        return ResponseEntity.ok(equipeRepository.listEquipes());

    }

    @GetMapping("/fla")
    public String fla() {
        return "flamengo";
    }


}
