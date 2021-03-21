package com.IJeans.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.ProdutoModel;
import com.IJeans.Backend.repositories.ProdutoRepository;
import com.IJeans.Backend.service.ProdutosService;

@Service
public class ProdutoServiceImpl implements ProdutosService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public List<ProdutoModel> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public void cadastrar(ProdutoModel produto) throws Exception {
		ProdutoModel produtoretorno = produtoRepository.findByNome(produto.getNome());
		
		if(produtoretorno != null) {
			throw new Exception("produto ja existente");
		}
		
		produtoRepository.save(produto);
	}

	
}
