package com.IJeans.Backend.service.impl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ProdutoModel cadastrar(ProdutoModel produto) throws Exception {
		ProdutoModel produtoretorno = produtoRepository.findByNome(produto.getNome());
		
		if(produtoretorno != null) {
			throw new Exception("produto ja existente");
		}
		
		produtoRepository.save(produto);
		return produto;
	}

	@Override
	public ProdutoModel deletar(String id) {
		Optional<ProdutoModel> produtoretorno = produtoRepository.findById(id);
		
		System.out.println("a");
		ProdutoModel produto = produtoretorno.get();
		if(produtoretorno != null){
			produto.setStatus(false);
			this.produtoRepository.save(produto);
			return produto;
		}
		return new ProdutoModel();
	}

	@Override
	public ProdutoModel atualizar(ProdutoModel produto) {
		Optional<ProdutoModel> produtoretorno = produtoRepository.findById(produto.getId());
		
		if(produtoretorno.isPresent()) {
			this.produtoRepository.save(produto);
			return produto;
		}
		return new ProdutoModel();
	}

	@Override
	public ProdutoModel findById(String id) throws FileNotFoundException {
		Optional<ProdutoModel> produtoretorno = produtoRepository.findById(id);
		
		if(produtoretorno.isPresent()) {
			return produtoretorno.get();
		}else {
			throw new FileNotFoundException();
		}
		
	}

	
}
