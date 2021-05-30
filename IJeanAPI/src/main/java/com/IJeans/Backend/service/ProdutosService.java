package com.IJeans.Backend.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutosService {

	List<ProdutoModel> findAll();
	
	void cadastrar(ProdutoModel produto);

	void atualizar(ProdutoModel produto);

<<<<<<< HEAD
	Optional<ProdutoModel> findById(String id);
=======
	ProdutoModel atualizar(ProdutoModel produto);
	
	ProdutoModel findById(String id) throws FileNotFoundException;
	
>>>>>>> 95a9c2a64c3b489a880584e6dae7d62a66b19aae

	void deletar(ProdutoModel produtoModel);
	
}
