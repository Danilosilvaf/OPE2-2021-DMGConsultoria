package com.IJeans.Backend.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutosService {

	List<ProdutoModel> findAll();
	
	void cadastrar(ProdutoModel produto);

	void atualizar(ProdutoModel produto);
	
	Optional<ProdutoModel> findById(String id) throws FileNotFoundException;

	void deletar(ProdutoModel produtoModel);

	Optional<ProdutoModel> findByNomeContaining(String nomeBusca);
	
}
