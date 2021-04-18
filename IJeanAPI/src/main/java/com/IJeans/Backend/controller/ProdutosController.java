package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<ProdutoModel> cadastrar(@RequestBody ProdutoModel produto){
		try {
			;
			return ResponseEntity.ok().body(produtoService.cadastrar(produto));
		}catch (Exception e){
			return ResponseEntity.ok().body(new ProdutoModel());
		}
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ProdutoModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(produtoService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.ok().body(new ProdutoModel());
		}
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public ResponseEntity<ProdutoModel> atualizar(@RequestBody ProdutoModel produto){
		try {
			;
			return ResponseEntity.ok().body(produtoService.atualizar(produto));
		}catch (Exception e){
			return ResponseEntity.ok().body(new ProdutoModel());
		}
	}
	
	
}
