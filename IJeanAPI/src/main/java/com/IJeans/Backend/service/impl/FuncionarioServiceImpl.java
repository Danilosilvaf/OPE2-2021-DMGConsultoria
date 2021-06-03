package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	@Override
	@Transactional
	public void deletar(FuncionarioModel funcionario) {
		this.funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional
	public void atualizar(FuncionarioModel funcionario) {
		this.funcionarioRepository.save(funcionario);
	}
	
	public Optional<FuncionarioModel> findById(String id){
		return funcionarioRepository.findById(id);
	}

	@Override
	public Optional<List<FuncionarioModel>> findByNomeContaining(String nomeBusca) {
		return funcionarioRepository.findByNomeContaining(nomeBusca);
	}
}
