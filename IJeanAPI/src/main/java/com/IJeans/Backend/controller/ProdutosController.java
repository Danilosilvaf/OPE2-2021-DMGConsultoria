package com.IJeans.Backend.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.ProdutoModel;
import com.IJeans.Backend.service.ProdutosService;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin(origins = "*")
public class ProdutosController {

	@Autowired
	private ProdutosService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll(){
		List<ProdutoModel> produtos = produtoService.findAll();
		if (produtos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(produtoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoModel> findByID(@PathVariable("id") String id){
		
		try {
			return ResponseEntity.ok().body(produtoService.findById(id));
		} catch (FileNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public ResponseEntity<ProdutoModel> cadastrar(@RequestBody ProdutoModel produto){
		try {
			;
			return ResponseEntity.ok().body(produtoService.cadastrar(produto));
		}catch (Exception e){
			return ResponseEntity.ok().body(new ProdutoModel());
		}
	}
	@CrossOrigin(origins = "*")
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
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}
