package com.IJeans.Backend.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.LoteModel;
import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;
import com.IJeans.Backend.repositories.LoteRepository;
import com.IJeans.Backend.repositories.MovimentacaoDeEstoqueRepository;
import com.IJeans.Backend.repositories.ProdutoRepository;
import com.IJeans.Backend.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService{

	@Autowired
	private MovimentacaoDeEstoqueRepository movimentacaoRepository;
	
	@Autowired
	private LoteRepository loteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void registrarTransacao(@Valid @RequestBody EstoqueDto transacao) throws Exception {
		
		LoteModel lote =new LoteModel(transacao) ;
		
		loteRepository.save(lote);
		movimentacaoRepository.save(new MovimentacaoDeEstoqueModel(transacao,lote));
		transacao.calcularQuantidade();
		produtoRepository.save(transacao.getProduto());
	}

	
}
