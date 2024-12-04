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

	@Test
	public void testeAtualizarEquipe() {
		Equipe cri = new Equipe(UUID.randomUUID(), "Criciuma", LocalDate.of(1919,9,14), "SC",0,0, true);
		equipeRepository.addEquipe(cri);
		cri.setTitulosNacionais(1);
		cri.setSerieA(false);
		equipeRepository.addEquipe(cri);
		Assertions.assertEquals(1,cri.getTitulosNacionais());
		Assertions.assertFalse(cri.isSerieA());
	}

	@Test
	public void adicionarEquipeDuplicada() {
		UUID equipeID = UUID.randomUUID();
		Equipe ava = new Equipe(equipeID, "Avaí", LocalDate.of(1920,5,20), "SC",0,0, false);
		equipeRepository.addEquipe(ava);
		Equipe ava2 = new Equipe(equipeID, "Avaí #2", LocalDate.of(1920,5,20), "SC",0,0, false);
		equipeRepository.addEquipe(ava2);
		Assertions.assertEquals("Avaí #2",equipeRepository.getEquipeById(equipeID).getNome());
	}

//	@Test
//	public void testeValidacaoDados()  {
//		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {//O lambda (() -> { /* código */ }) é uma maneira concisa de definir uma função anônima em Java.
//																											//No caso do teste, o lambda representa o bloco de código que está sendo testado — ele tenta criar uma nova instância da classe Equipe com argumentos inválidos.
//																											//O métod assertThrows recebe dois argumentos:
//																											//O tipo da exceção esperada: IllegalArgumentException.class.
//																											//Um lambda que executa o código cuja exceção queremos verificar.
//			new Equipe(UUID.randomUUID(), null, LocalDate.of(2000, 1, 1), "SP", 0, 0, false);
//		});
//		Assertions.assertEquals("O nome da equipe não pode ser nulo", exception.getMessage());
																													/*Fluxo completo do teste com o lambda
																											O lambda tenta executar um código inválido.
																											O assertThrows monitora esse código em busca de uma exceção do tipo esperado.
																											Se a exceção for lançada:
																											O assertThrows captura a exceção.
																											Retorna a instância da exceção para que você possa analisá-la (mensagem, por exemplo).
																											Se nenhuma exceção for lançada ou uma exceção incorreta for lançada:
																											O teste falha, indicando que o comportamento esperado não foi atendido.*/
//}

}
