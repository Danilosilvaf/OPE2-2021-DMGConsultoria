package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.model.MarcaModel;
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

	@Override
	public FuncionarioModel deletar(String id) {
		Optional<FuncionarioModel> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			this.funcionarioRepository.deleteById(funcionario);
		}
		return new FuncionarioModel();
	}

	@Override
	public FuncionarioModel atualizar(FuncionarioModel funcionario) {
		Optional<FuncionarioModel> funcionarioretorno = funcionarioRepository.findById(funcionario.getId());
		
		if(funcionarioretorno.isPresent()) {
			this.funcionarioRepository.save(funcionario);
			return funcionario;
		}
		return new FuncionarioModel();
	}
}
