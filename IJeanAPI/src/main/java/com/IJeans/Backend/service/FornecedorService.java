package com.IJeans.Backend.service;

import java.util.List;

import com.IJeans.Backend.model.FornecedorModel;

public interface FornecedorService {

	List<FornecedorModel> findAll();
	
	void cadastrarFornecedor(FornecedorModel fornecedor);

	FornecedorModel atualizar(FornecedorModel fornecedor);

	FornecedorModel deletar(String id);
}
