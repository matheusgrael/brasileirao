package com.matheusgrael.Brasileirao.services;

import com.matheusgrael.Brasileirao.dominio.Equipe;
import com.matheusgrael.Brasileirao.dominio.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Map<UUID, Equipe> listagem() {
        return equipeRepository.listAllEquipes();
    }

    public Equipe buscarPorId(UUID id) {
        Equipe equipe = equipeRepository.getEquipeById(id);
    }

    public void deletarPorId(UUID id) {
        equipeRepository.deleteById(id);
    }


}
