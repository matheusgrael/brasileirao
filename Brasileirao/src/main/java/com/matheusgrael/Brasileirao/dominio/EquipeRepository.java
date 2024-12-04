package com.matheusgrael.Brasileirao.dominio;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class EquipeRepository {

    private Map<UUID, Equipe> listaDeEquipes = new HashMap<>();

    public EquipeRepository() {
    addEquipe(new Equipe(UUID.randomUUID(), "Flamengo", LocalDate.of(1895,11,15),"RJ",16, 6, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Botafogo", LocalDate.of(1907,10,10),"RJ",2, 2, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Fluminense", LocalDate.of(1897,07,03),"RJ",5, 3, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Vasco", LocalDate.of(1893,04,25),"RJ",5, 4, false));
    addEquipe(new Equipe(UUID.randomUUID(), "Cruzeiro", LocalDate.of(1906,01,29),"MG",10, 7, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Atético MG", LocalDate.of(1901,04,13),"MG",7, 4, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Santos", LocalDate.of(1890,06,16),"SP",9, 8, false));
    addEquipe(new Equipe(UUID.randomUUID(), "São Paulo", LocalDate.of(1914,07,02),"SP",8, 12, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Palmeiras", LocalDate.of(1911,04,01),"SP",15, 6, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Corinthians", LocalDate.of(1910,03,14),"SP",11, 4, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Internacional", LocalDate.of(1914,01,11),"RS",4, 7, true));
    addEquipe(new Equipe(UUID.randomUUID(), "Gremio", LocalDate.of(1902,05,04),"RS",8, 6, true));
    }

    public void addEquipe(Equipe equipe) {
        listaDeEquipes.put(equipe.getId(), equipe);
    }

    public Map<UUID, Equipe> listAllEquipes() {
        //return listaDeEquipes; */listAllEquipes retorna o Map diretamente. Isso permite que o estado interno do repositório seja alterado externamente. Considere retornar uma cópia do mapa para evitar alterações não controladas:
        return new HashMap<>(listaDeEquipes);
    }

//    public void listEquipes() {
//        for(Equipe equipe : listaDeEquipes.values()) {
//            System.out.println("______________________________________________________________");
//            System.out.println("Nome: " + equipe.getNome());
//            System.out.println("Anos de História: " + equipe.anosHistoria());
//            System.out.println("Estado: " + equipe.getEstado());
//            System.out.println("Títulos Nacionais: " + equipe.getTitulosNacionais());
//            System.out.println("Títulos Internacionais: " + equipe.getTitulosInternacionais());
//            System.out.println("Joga a série A? : " + (equipe.isSerieA() ? "sim" : "não"));
//            System.out.println("______________________________________________________________");
//        }
//    }

    public Equipe getEquipeById(UUID id) {
        return listaDeEquipes.get(id);
    }

    public void deleteById(UUID id) {
        listaDeEquipes.remove(id);
    }


}


