package com.qualirede.api.repositorio;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qualirede.api.dominio.DominioAutoriza;
import com.qualirede.api.dominio.DominioSexo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcedimentoRepositorioTest {
	
	@Autowired
	private ProcedimentoRepositorio repositorio;
	
	@Test
	public void testaProcedimentoNaoExistente() {
		DominioAutoriza autoriza = repositorio.getAutoriza(111, 15, DominioSexo.F);
		assertThat(autoriza == null);
	}
	
	@Test
	public void testaProcedimentoExistente() {
		DominioAutoriza autoriza = repositorio.getAutoriza(1234, 10, DominioSexo.M);
		assertThat(autoriza == null);
	}

}
