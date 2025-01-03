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
        return equipeRepository.getEquipeById(id);
    }

    public void deletarPorId(UUID id) {
        equipeRepository.deleteById(id);
    }

    public Map<UUID,Equipe> buscarPorEstado(String uf) {
        Map<UUID,Equipe> equipes = equipeRepository.listAllEquipes();
        if(uf != null) {
            equipes.values().removeIf(e -> !e.getEstado().equalsIgnoreCase(uf));
        }
        return equipes;
    }

    public Map<UUID,Equipe> buscarSerieA(boolean serieA) {
        Map<UUID,Equipe> equipes = equipeRepository.listAllEquipes();
        if(serieA == true) {
            equipes.values().removeIf(e -> e.isSerieA() == false)
        } else {
            equipes.values().removeIf(e -> e.isSerieA() == true)
        }
        return equipes;
    }

    public Equipe criarEquipe(Equipe equipe) {
        equipe.setId(UUID.randomUUID());
        equipeRepository.addEquipe(equipe);
        return equipe;
    }


}
