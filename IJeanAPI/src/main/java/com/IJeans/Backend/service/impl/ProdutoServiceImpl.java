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
	public void cadastrar(ProdutoModel produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void deletar(ProdutoModel produto) {
		produto.setStatus(false);
		this.produtoRepository.save(produto);
	}

	@Override
	public void atualizar(ProdutoModel produto) {
        this.produtoRepository.save(produto);
    }

	@Override
	public Optional<ProdutoModel> findById(String id) {
		return produtoRepository.findById(id);
	}

<<<<<<< HEAD
=======
	@Override
	public ProdutoModel findById(String id) throws FileNotFoundException {
		Optional<ProdutoModel> produtoretorno = produtoRepository.findById(id);
		
		if(produtoretorno.isPresent()) {
			return produtoretorno.get();
		}else {
			throw new FileNotFoundException();
		}
		
	}

	
>>>>>>> 95a9c2a64c3b489a880584e6dae7d62a66b19aae
}
