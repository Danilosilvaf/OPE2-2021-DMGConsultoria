package com.IJeans.Backend.service;

import java.util.List;

import java.util.Optional;
import com.IJeans.Backend.model.FuncionarioModel;

public interface FuncionarioService {

	List<FuncionarioModel> findAll();
	
	void cadastrarFuncionario(FuncionarioModel funcionario);

	void atualizar(FuncionarioModel funcionario);

	Optional<FuncionarioModel> findById(String id);

	void deletar(FuncionarioModel funcionario);

	Optional<List<FuncionarioModel>> findByNomeContaining(String nomeBusca);
}
