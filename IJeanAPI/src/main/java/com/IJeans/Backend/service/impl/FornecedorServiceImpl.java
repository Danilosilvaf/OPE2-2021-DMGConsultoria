package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.repositories.FornecedorRepository;
import com.IJeans.Backend.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<FornecedorModel> findAll() {
		return fornecedorRepository.findAll();
	}

	public void cadastrarFornecedor(FornecedorModel fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void deletar(FornecedorModel fornecedor) {
		fornecedor.setStatus(false);
		this.fornecedorRepository.save(fornecedor);
	}

	@Override
	public void atualizar(FornecedorModel fornecedor) {
		this.fornecedorRepository.save(fornecedor);
	}

	@Override
	public Optional<FornecedorModel> findById(String id) {
		return fornecedorRepository.findById(id);
	}

}
