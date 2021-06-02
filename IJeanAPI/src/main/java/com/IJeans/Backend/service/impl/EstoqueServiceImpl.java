package com.IJeans.Backend.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.exception.NumeroNegativoException;
import com.IJeans.Backend.exception.ProdutoExistenteException;
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

	@Override
	public void registrarVenda(@Valid EstoqueDto transacao) throws Exception{
		
		
		/**
		 * TODO
		 * Pegar Lote e alterar a quantidade Done	
		 * Dar um jeito no fornecedor Done
		 */
		Optional<List<LoteModel>> lote =loteRepository.findByIdProduto(transacao.getProduto().getId());
		
		int valor = transacao.getQuantidade();
		if(lote.isPresent()) {
			List<LoteModel> lstLote = lote.get();
			int totalqtd =0;
			for(LoteModel lotec:lstLote) {
				totalqtd += lotec.getQuantidade();
			}
			if(totalqtd < transacao.getQuantidade())
				throw new NumeroNegativoException("Quantidade de produtos maior que a atual");
			
			
			
			
			for(LoteModel lotec:lstLote) {
				if(lotec.getQuantidade() == 0) {
					continue;
				}
				
				if(lotec.getQuantidade() >= transacao.getQuantidade()) {
					lotec.setQuantidade(lotec.getQuantidade()-transacao.getQuantidade());
					loteRepository.save(lotec);
					movimentacaoRepository.save(new MovimentacaoDeEstoqueModel(transacao,lotec));
					break;
				}
					if((transacao.getQuantidade() -lotec.getQuantidade()) > 0 ) {
						transacao.setQuantidade(transacao.getQuantidade() -lotec.getQuantidade());
						lotec.setQuantidade(0);
						loteRepository.save(lotec);
						movimentacaoRepository.save(new MovimentacaoDeEstoqueModel(transacao,lotec));
						continue;
					}
					
					
				
			}
			
			transacao.getProduto().setQuantidade_estoque(transacao.getProduto().getQuantidade_estoque() - valor);
			produtoRepository.save(transacao.getProduto());
			
		}else {
			throw new ProdutoExistenteException("Produto sem estoque disponivel");
		}
		
	}

}

