package com.qualirede.api.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qualirede.api.dominio.DominioAutoriza;
import com.qualirede.api.dominio.DominioSexo;
import com.qualirede.api.entidade.Procedimento;
import com.qualirede.api.repositorio.ProcedimentoRepositorio;

@RestController
@RequestMapping("/autorizador")
public class ProcedimentoResource {
	
	@Autowired
	private ProcedimentoRepositorio procedimentoRepositorio;
	
	@GetMapping
	public List<Procedimento> listar(){ 
		return procedimentoRepositorio.findAll();
	}
	
	@PostMapping("/cadastro/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}")
	public ResponseEntity<Procedimento> cadastroProcedimento(@PathVariable("procedimento") Integer procedimento, @PathVariable("idade") Integer idade,
			@PathVariable("sexo") String sexo, @PathVariable("autoriza") String autoriza) {
		try {
			DominioSexo domSexo = DominioSexo.valueOf(sexo);
			DominioAutoriza domAutoriza = DominioAutoriza.valueOf(autoriza);
			
			Procedimento novoProcedimento = new Procedimento(procedimento, idade, domSexo, domAutoriza);
			
			Procedimento procedimentoSalvo = procedimentoRepositorio.save(novoProcedimento);
			return ResponseEntity.ok(procedimentoSalvo);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}
	
	@GetMapping("/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}")
	public ResponseEntity<DominioAutoriza> cadastroProcedimento(@PathVariable("procedimento") Integer procedimento, @PathVariable("idade") Integer idade,
			@PathVariable("sexo") String sexo) {
		try {
			DominioSexo domSexo = DominioSexo.valueOf(sexo);
			
			DominioAutoriza autoriza = procedimentoRepositorio.getAutoriza(procedimento, idade, domSexo);
			
			autoriza = autoriza != null ? autoriza : DominioAutoriza.NAO;
			
			return ResponseEntity.ok(autoriza);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}

}
