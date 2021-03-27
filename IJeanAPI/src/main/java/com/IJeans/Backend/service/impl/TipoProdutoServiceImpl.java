package com.IJeans.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.TipoProdutoModel;
import com.IJeans.Backend.repositories.TipoProdutoRepository;
import com.IJeans.Backend.service.TipoProdutoService;

@Service
public class TipoProdutoServiceImpl implements TipoProdutoService{

	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@Override
	public List<TipoProdutoModel> findAll() {
		return tipoProdutoRepository.findAll();
	}
}
