package com.IJeans.Backend.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;

public interface MovimentacaoDeEstoqueService {

	List<MovimentacaoDeEstoqueModel> findAll();

	Optional<MovimentacaoDeEstoqueModel> findById(String id);

	void registrarTransacao(@Valid EstoqueDto transacao);

}
