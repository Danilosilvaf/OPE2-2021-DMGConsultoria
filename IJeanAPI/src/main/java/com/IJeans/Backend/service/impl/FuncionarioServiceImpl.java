package com.IJeans.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.repositories.FuncionarioRepository;
import com.IJeans.Backend.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<FuncionarioModel> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public void cadastrarFuncionario(FuncionarioModel funcionario) {
		funcionarioRepository.save(funcionario);
	}
}
