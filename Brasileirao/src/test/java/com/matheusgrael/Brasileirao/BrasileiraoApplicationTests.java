package com.matheusgrael.Brasileirao;

import com.matheusgrael.Brasileirao.dominio.Equipe;
import com.matheusgrael.Brasileirao.dominio.EquipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class BrasileiraoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EquipeRepository equipeRepository;

	@Test
	public void testeAdicionarEquipe() {
		Equipe equipe = new Equipe(UUID.randomUUID(), "Volra Redonda",LocalDate.of(1995,05,14), "RJ", 0, 0, false);
		equipeRepository.addEquipe(equipe);
		Assertions.assertNotNull(equipeRepository.getEquipeById(equipe.getId()));
	}

}
