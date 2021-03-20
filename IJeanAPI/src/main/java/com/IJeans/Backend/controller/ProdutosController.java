package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.ProdutoModel;
import com.IJeans.Backend.service.ProdutosService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosService produtoService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoModel>> getAll(){
		return ResponseEntity.ok().body(produtoService.findAll());
	}
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<String> cadastrar(@RequestBody ProdutoModel produto){
		try {
			produtoService.cadastrar(produto);
			return ResponseEntity.ok().body("Produto Cadastrado");
		}catch (Exception e){
			return ResponseEntity.ok().body("Erro ao Cadastrar Produto" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/pages",method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoModel>> findPage(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "qtdLinhas", defaultValue = "10") int qtdLinhas,
            @RequestParam(value = "direcao", defaultValue = "ASC") String direcao,
            @RequestParam(value = "campo", defaultValue = "idProduto") String campo){
		
		Page<ProdutoModel> pageProdutos = produtoService.FindAllPages(pagina, qtdLinhas, direcao, campo);
		return ResponseEntity.ok().body(pageProdutos);
	}
	
	
}
