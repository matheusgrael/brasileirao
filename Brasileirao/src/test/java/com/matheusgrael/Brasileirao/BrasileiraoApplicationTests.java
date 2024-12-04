package com.matheusgrael.Brasileirao;

import com.matheusgrael.Brasileirao.dominio.Equipe;
import com.matheusgrael.Brasileirao.dominio.EquipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Map;
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
		Equipe vr = new Equipe(UUID.randomUUID(), "Volta Redonda",LocalDate.of(1995,05,14), "RJ", 0, 0, false);
		equipeRepository.addEquipe(vr);
		Assertions.assertNotNull(equipeRepository.getEquipeById(vr.getId()));
	}

	@Test
	public void excluirEquipes() {
		Equipe amg = new Equipe(UUID.randomUUID(), "América-MG", LocalDate.of(1903,10,17), "MG",0,0, false);
		equipeRepository.addEquipe(amg);
		UUID amgID = amg.getId();
		equipeRepository.deleteById(amgID);
		Assertions.assertNull(equipeRepository.getEquipeById(amgID));
	}

	@Test
	public void testeBuscaPorEstado() {
		Equipe cap = new Equipe(UUID.randomUUID(), "Athlético-PR", LocalDate.of(1923,07,3), "PR",3,2, true);
		Equipe cor = new Equipe(UUID.randomUUID(), "Coritiba", LocalDate.of(1909,02,22), "PR",2,0, false);
		Equipe par = new Equipe(UUID.randomUUID(), "Paraná", LocalDate.of(1891,8,14), "PR",1,0, false);
		equipeRepository.addEquipe(cap);
		equipeRepository.addEquipe(cor);
		equipeRepository.addEquipe(par);
		Map<UUID, Equipe> equipesPR = equipeRepository.listAllEquipes();
		equipesPR.values().removeIf(e -> !e.getEstado().equalsIgnoreCase("PR"));
		Assertions.assertEquals(3, equipesPR.size());
	}

//	@Test
//	public void testeBuscaPorSerieA

}
