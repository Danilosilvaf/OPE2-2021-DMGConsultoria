package com.IJeans.Backend.service;

import java.util.List;
import java.util.Optional;

import com.IJeans.Backend.model.FornecedorModel;

public interface FornecedorService {

	List<FornecedorModel> findAll();
	
	void cadastrarFornecedor(FornecedorModel fornecedor);

	void atualizar(FornecedorModel fornecedor);

	public void deletar(FornecedorModel fornecedor) throws Exception;

	Optional<FornecedorModel> findById(String id);

	Optional<List<FornecedorModel>> findByNomeContaining(String nomeBusca);

}
