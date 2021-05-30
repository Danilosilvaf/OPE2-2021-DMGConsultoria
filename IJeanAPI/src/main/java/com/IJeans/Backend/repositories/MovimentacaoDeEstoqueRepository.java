package com.IJeans.Backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;

public interface MovimentacaoDeEstoqueRepository extends JpaRepository<MovimentacaoDeEstoqueModel, String>{

	void save(EstoqueDto transacao);

}
