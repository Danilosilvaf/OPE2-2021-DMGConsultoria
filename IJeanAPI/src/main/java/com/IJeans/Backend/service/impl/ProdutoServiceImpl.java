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
	public void cadastrar(ProdutoModel produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Page<ProdutoModel> FindAllPages(int pagina, int qtdLinhas, String direcao, String campo) {
		PageRequest pageRequest = PageRequest.of(pagina, qtdLinhas, Direction.valueOf(direcao), campo);
        return produtoRepository.findAll(pageRequest);
	}
	
}
