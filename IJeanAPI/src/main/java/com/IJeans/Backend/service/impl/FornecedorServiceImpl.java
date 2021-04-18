package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.repositories.FornecedorRepository;
import com.IJeans.Backend.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public List<FornecedorModel> findAll(){
		return fornecedorRepository.findAll();
	}
	
	public void cadastrarFornecedor(FornecedorModel fornecedor) {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public FornecedorModel deletar(String id) {
			Optional<FornecedorModel> fornecedorretorno = fornecedorRepository.findById(id);
			
			System.out.println("a");
			FornecedorModel fornecedor = fornecedorretorno.get();
			if(fornecedorretorno != null){
				fornecedor.setStatus(false);
				this.fornecedorRepository.save(fornecedor);
				return fornecedor;
			}
			return new FornecedorModel();
		}

	@Override
	public FornecedorModel atualizar(FornecedorModel fornecedor) {
			Optional<FornecedorModel> fornecedorretorno = fornecedorRepository.findById(fornecedor.getId());
			
			if(fornecedorretorno.isPresent()) {
				this.fornecedorRepository.save(fornecedor);
				return fornecedor;
			}
			return new FornecedorModel();
		}
}
