package com.IJeans.Backend.service;

import java.util.List;

import com.IJeans.Backend.model.FuncionarioModel;

public interface FuncionarioService {

	List<FuncionarioModel> findAll();
	
	void cadastrarFuncionario(FuncionarioModel funcionario);
}
