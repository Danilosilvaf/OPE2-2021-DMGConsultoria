package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;
import com.IJeans.Backend.repositories.MovimentacaoDeEstoqueRepository;
import com.IJeans.Backend.service.MovimentacaoDeEstoqueService;

@Service
public class MovimentacaoDeEstoqueServiceImpl implements MovimentacaoDeEstoqueService{

	@Autowired
	private MovimentacaoDeEstoqueRepository movimentacaoRepository;

	@Override
	public List<MovimentacaoDeEstoqueModel> findAll() {
		return movimentacaoRepository.findAll();
	}
	
	@Override
	public Optional<MovimentacaoDeEstoqueModel> findById(String id) {
		return movimentacaoRepository.findById(id);
	}

	@Override
	public void registrarTransacao(MovimentacaoDeEstoqueModel transacao) {
		movimentacaoRepository.save(transacao);
	}
	
}
