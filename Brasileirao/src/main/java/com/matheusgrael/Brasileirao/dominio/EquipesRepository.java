package com.matheusgrael.Brasileirao.dominio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EquipesRepository {

    private Map<UUID, Equipes> listaDeEquipes = new HashMap<>();

    Equipes flamengo = new Equipes(UUID.randomUUID(), "Flamengo", LocalDate.of(1895,11,15),
                        "RJ",16, 6, true);

    Equipes botafogo = new Equipes(UUID.randomUUID(), "Botafogo", LocalDate.of(1907,10,10),
            "RJ",2, 1, true);

    Equipes fluminense = new Equipes(UUID.randomUUID(), "Fluminense", LocalDate.of(1897,07,03),
            "RJ",5, 3, true);

    Equipes vasco = new Equipes(UUID.randomUUID(), "Vasco", LocalDate.of(1893,04,25),
            "RJ",5, 4, false);

    Equipes cruzeiro = new Equipes(UUID.randomUUID(), "Cruzeiro", LocalDate.of(1906,01,29),
            "MG",10, 7, true);

    Equipes atleticoMG = new Equipes(UUID.randomUUID(), "Atético MG", LocalDate.of(1901,04,13),
            "MG",7, 4, true);

    Equipes santos = new Equipes(UUID.randomUUID(), "Santos", LocalDate.of(1890,06,16),
            "SP",9, 8, false);

    Equipes saoPaulo = new Equipes(UUID.randomUUID(), "São Paulo", LocalDate.of(1914,07,02),
            "SP",8, 12, true);

    Equipes palmeiras = new Equipes(UUID.randomUUID(), "Palmeiras", LocalDate.of(1911,04,01),
            "SP",15, 6, true);

    Equipes corinthians = new Equipes(UUID.randomUUID(), "Corinthians", LocalDate.of(1910,03,14),
            "SP",11, 4, true);

    Equipes internacional = new Equipes(UUID.randomUUID(), "Internacional", LocalDate.of(1914,01,11),
            "RS",4, 7, true);

    Equipes gremio = new Equipes(UUID.randomUUID(), "Gremio", LocalDate.of(1902,05,04),
            "RS",8, 6, true);



}

