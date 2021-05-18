package com.IJeans.Backend.service;

import java.util.List;

import java.util.Optional;
import com.IJeans.Backend.model.FuncionarioModel;

public interface FuncionarioService {

	List<FuncionarioModel> findAll();
	
	void cadastrarFuncionario(FuncionarioModel funcionario);

	FuncionarioModel deletar(String id);

	FuncionarioModel atualizar(FuncionarioModel funcionario);

	Optional<FuncionarioModel> findById(String id);

	void deletar(FuncionarioModel funcionarioModel);
}
