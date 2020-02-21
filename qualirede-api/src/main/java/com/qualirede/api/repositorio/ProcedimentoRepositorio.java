package com.qualirede.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qualirede.api.dominio.DominioAutoriza;
import com.qualirede.api.dominio.DominioSexo;
import com.qualirede.api.entidade.Procedimento;

public interface ProcedimentoRepositorio extends JpaRepository<Procedimento, Long> {

	@Query(
			"SELECT p.autoriza "
		  + "FROM Procedimento p "
		  + "WHERE p.procedimento = ?1 "
		  + "AND p.idade = ?2 "
		  + "AND p.sexo = ?3 ")
	DominioAutoriza getAutoriza(Integer procedimento, Integer idade, DominioSexo domSexo);

}
