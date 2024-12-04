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
		Equipe equipe = new Equipe(UUID.randomUUID(), "Volta Redonda",LocalDate.of(1995,05,14), "RJ", 0, 0, false);
		equipeRepository.addEquipe(equipe);
		Assertions.assertNotNull(equipeRepository.getEquipeById(equipe.getId()));
	}

	@Test
	public void testeListagemEquipes() {
//		Equipe fla = new Equipe(UUID.randomUUID(), "Flamengo", LocalDate.of(1895,11,15), "RJ",16,6, true);
//		Equipe bot = new Equipe(UUID.randomUUID(), "Botafogo", LocalDate.of(1907,10,10), "RJ",2, 2, true);
//		equipeRepository.addEquipe(fla);
//		equipeRepository.addEquipe(bot);
		Assertions.assertEquals(13,equipeRepository.listAllEquipes().size());
	}

}
