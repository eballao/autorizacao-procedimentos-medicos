package com.qualirede.api.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/cadastro/procedimento")
	public ResponseEntity<Procedimento> cadastroProcedimento() {
		Procedimento procedimento = new Procedimento();
//		return ResponseEntity.status(HttpStatus.OK).body(procedimento);
		return ResponseEntity.ok(procedimento);
	}

}
