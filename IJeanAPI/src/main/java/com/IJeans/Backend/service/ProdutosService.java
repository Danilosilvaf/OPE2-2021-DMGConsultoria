package com.IJeans.Backend.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.domain.Page;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutosService {

	List<ProdutoModel> findAll();
	
	ProdutoModel cadastrar(ProdutoModel produto) throws Exception;

	ProdutoModel deletar(String id);

	ProdutoModel atualizar(ProdutoModel produto);
	
	ProdutoModel findById(String id) throws FileNotFoundException;
	

}
