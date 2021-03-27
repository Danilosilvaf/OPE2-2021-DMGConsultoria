package com.IJeans.Backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutosService {

	List<ProdutoModel> findAll();
	
	ProdutoModel cadastrar(ProdutoModel produto) throws Exception;
	

}
