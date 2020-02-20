package com.qualirede.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qualirede.api.entidade.Procedimento;

public interface ProcedimentoRepositorio extends JpaRepository<Procedimento, Long> {

}
